class Particle {
  constructor(index, parent) {
    this.index = index;
    this.parent = parent;
    this.minSize = 5;
    this.init();
  }
  init() {
    this.freqVal = this.parent.freqData[this.index] * 0.01;
    this.size = (this.freqVal * ((this.parent.dimensions.x + this.parent.dimensions.y) * 0.5) * 0.0125) + this.minSize;
    this.position = new Vector2(Math.random() * this.parent.dimensions.x, this.parent.dimensions.y + this.size);
    this.velocity = new Vector2(2 - Math.random() * 4, 0);
  }
  update() {
    this.freqVal = this.parent.freqData[this.index] * 0.01;

    this.size = (this.freqVal * ((this.parent.dimensions.x + this.parent.dimensions.y) * 0.5) * 0.025) + this.minSize;
    this.offset = this.size / 2;

    this.hue = ((this.index / this.parent.bufferLen) * 360) + 120 + this.parent.tick / 6;
    this.saturation = this.freqVal * 20;
    this.alpha = this.freqVal * 0.3;

    this.fill = 'hsla(' + this.hue + ',' + this.saturation + '%,50%,' + this.alpha + ')';

    this.lift = Math.pow(this.freqVal, 3);

    this.position.subY(this.lift + 1);
    this.position.add(this.velocity);

    this.checkBounds();
  }
  checkBounds() {
    if (this.position.y < -this.size || this.position.x < -this.parent.dimensions.x * 0.15 || this.position.x > this.parent.dimensions.x * 1.15) {
      this.init();
    }
  }
}

class App {
  constructor() {
    let self = this;
    this.globalMovement = new Vector2();
    this.initCanvas();
    this.initUI();
    this.initAudio();
    // this.loadAudio();
    this.populate();
    this.render();
    window.onresize = () => {
      self.resize();
    };
  }


  initCanvas() {
    this.tick = 0;
    this.dark = false;
    this.wave = true;
    this.canvas = document.getElementById('canvas');
    this.ctx = this.canvas.getContext('2d');
    this.dimensions = {};
    this.resize();
  }

  resize() {
    this.canvas.width = this.dimensions.x = window.innerWidth;
    this.canvas.height = this.dimensions.y = window.innerHeight;
  }


  initUI() {
    let self = this;
    this.controls = {
      wave: document.querySelector('#btn-wave'),
      lights: document.querySelector('#btn-lights'),
      prev: document.querySelector('#btn-prev'),
      next: document.querySelector('#btn-next'),
      play: document.querySelector('#btn-play'),
      progressBar: document.querySelector('.line_played'),
      preloadBar: document.querySelector('.line_preload'),
      curTime: document.querySelector('.time_played'),
      durTime: document.querySelector('.full_time')
    };

    this.controls.wave.onclick = () => {
      let i = self.controls.wave.getElementsByTagName('i')[0];

      if (self.wave) {
        i.classList.add('off');
        self.wave = false;
      } else if (!self.wave) {
        i.classList.remove('off');
        self.wave = true;
      }
    };
    this.controls.lights.onclick = () => {
      let i = self.controls.lights.getElementsByTagName('i')[0];
      if (self.dark) {
        i.classList.remove('off');
        // self.background.classList.remove('hidden');
        self.background.style.visibility = 'visible';
        self.dark = false;
      } else if (!self.dark) {
        i.classList.add('off');
        // self.background.classList.add('hidden');
        self.background.style.visibility = 'hidden';
        self.dark = true;
      }
    };
    this.controls.prev.onclick = () => {
      self.currentSong = self.currentSong > 1 ? self.currentSong - 1 : self.fileNames.length;
      self.loadAudio();
    };
    this.controls.next.onclick = () => {
      self.currentSong = self.currentSong < self.fileNames.length ? self.currentSong + 1 : 1;
      self.loadAudio();
    };
    this.controls.play.onclick = () => {
      let i = self.controls.play.getElementsByTagName('i')[0];
      if (self.playing && self.audioReady) {
        i.classList.remove('fa-pause');
        i.classList.add('fa-play');
        self.audio.pause();
        self.playing = false;
      } else if (!self.playing && self.audioReady) {
        i.classList.remove('fa-play');
        i.classList.add('fa-pause');
        self.audio.play();
        self.playing = true;
      }
    };

    this.background = document.getElementById("canvas");
    this.title = document.getElementById('song-title');

    // Setting Defaults
    this.controls.progressBar.style.width = 0;
    this.controls.preloadBar.style.width = 0;
    this.controls.curTime.innerHTML = '--';
    this.controls.durTime.innerHTML = '--';
  }


  setAudioURL(baseURL, fileNames, songTitles) {
    let self = this;
    this.baseURL = baseURL;
    this.fileNames = fileNames;
    this.songTitles = songTitles;
  }

  initAudio() {
    let self = this;
    this.currentSong = 1;
    // this.baseURL = 'https://box1182.BlueHost.com/~seanale3/codepen/audio/';
    // this.fileNames = ['dmwaltz.mp3', 'nocturne92.mp3', 'mozart25.mp3', 'trista.mp3', 'waltzflowers.mp3'];
    // this.songTitles = ['Dmitri Shostakovich - Waltz No. 2', 'Frederic Chopin - Nocturne op. 9 no. 2', 'Mozart - Symphony no. 25', 'Heitor Villa-Lobos - Tristorosa', 'Pyotr Tchaikovsky - Waltz of the Flowers'];


    this.audio = document.getElementById('audio');
    this.audio.preload = 'auto';

    this.controls.progressBar.closest('.progress-bar-wrapper').addEventListener('mouseup', (evt) => {

      if (self.audio.readyState !== 0) {
        var value = Math.round(((evt.clientX - self.controls.progressBar.offset().left) + window.pageXOffset) * 100 / self.controls.progressBar.parentNode.offsetWidth);
        self.controls.progressBar.style.width = value + '%'
        self.audio.currentTime = this.audio.duration * (value / 100);
      }
    });

    Element.prototype.offset = function () {
      var el = this.getBoundingClientRect(),
        scrollLeft = window.pageXOffset || document.documentElement.scrollLeft,
        scrollTop = window.pageYOffset || document.documentElement.scrollTop;
      return {
        top: el.top + scrollTop,
        left: el.left + scrollLeft
      };
    };


    this.audio.addEventListener('timeupdate', () => {
      if (self.audio.readyState === 0) return;

      // Current Progress Bar
      var barlength = Math.round(self.audio.currentTime * (100 / self.audio.duration));
      self.controls.progressBar.style.width = barlength + '%';

      // Preload Bar
      var buffered = self.audio.buffered;
      if (buffered.length) {
        var loaded = Math.round(100 * buffered.end(0) / self.audio.duration);
        self.controls.preloadBar.style.width = loaded + '%';
      }


      var
        curMins = Math.floor(self.audio.currentTime / 60),
        curSecs = Math.floor(self.audio.currentTime - curMins * 60),
        mins = Math.floor(self.audio.duration / 60),
        secs = Math.floor(self.audio.duration - mins * 60);
      (curSecs < 10) && (curSecs = '0' + curSecs);
      (secs < 10) && (secs = '0' + secs);

      self.controls.curTime.innerHTML = curMins + ':' + curSecs;
      self.controls.durTime.innerHTML = mins + ':' + secs;

    });

    this.audio.addEventListener('ended', () => {
      self.audio.currentTime = 0;
      self.audio.pause();
      self.currentSong = self.currentSong < self.fileNames.length ? self.currentSong + 1 : 1;
      self.loadAudio();
    });

    this.audioCtx = new AudioContext();

    this.analyser = this.audioCtx.createAnalyser();
    this.source = this.audioCtx.createMediaElementSource(this.audio);

    this.source.connect(this.analyser);
    this.analyser.connect(this.audioCtx.destination);

    this.bufferLen = this.analyser.frequencyBinCount;
    this.freqData = new Uint8Array(this.bufferLen);
  }


  loadAudio() {
    let self = this;

    this.audioReady = false;
    this.playing = false;

    this.controls.prev.classList.add('disabled');
    this.controls.next.classList.add('disabled');
    this.controls.play.classList.add('disabled');

    self.playAudio();
  }
  playAudio() {
    this.audioReady = true;
    this.playing = true;

    this.title.innerHTML = this.songTitles[this.currentSong - 1];

    this.controls.prev.classList.remove('disabled');
    this.controls.next.classList.remove('disabled');
    this.controls.play.classList.remove('disabled');

    this.controls.play.getElementsByTagName('i')[0].classList.remove('fa-play');
    this.controls.play.getElementsByTagName('i')[0].classList.add('fa-pause');

    this.audio.crossOrigin = "anonymous";
    this.audio.src = this.baseURL+this.fileNames[this.currentSong-1];
    this.audio.play();
  }
  populate() {
    this.particles = [];
    for (let i = 0; i < this.bufferLen; i++) {
      this.particles.push(new Particle(i, this));
    }
  }
  update() {
    this.ctx.clearRect(0, 0, this.dimensions.x, this.dimensions.y);
    this.ctx.save();
    for (let i = 0, len = this.particles.length; i < len; i++) {
      let particle = this.particles[i];
      if (this.freqData[i] > 0) {
        particle.update();
        if (this.wave) particle.position.add(this.globalMovement);
        this.ctx.beginPath();
        this.ctx.fillStyle = particle.fill;
        this.ctx.beginPath();
        this.ctx.arc(particle.position.x, particle.position.y, particle.size, 0, Math.PI * 180);
        this.ctx.fill();
        this.ctx.closePath();
      }
    }
    this.ctx.restore();
  }
  render() {
    let self = this;
    this.tick++;
    if (this.wave) this.globalMovement.x = Math.sin(this.tick * 0.01) * 2;
    this.analyser.getByteFrequencyData(this.freqData);
    this.update();
    window.requestAnimationFrame(self.render.bind(self));
  }
}

function startplayer() {
  let app = new App();
};

