
DROP DATABASE IF EXISTS RetroPlaydb;
CREATE DATABASE  RetroPlaydb;
USE RetroPlaydb;

DROP TABLE IF EXISTS Playlist;

CREATE TABLE Playlist(
playlist_id VARCHAR(30) PRIMARY KEY,
playlist_name VARCHAR(30),
playlist_song_ids VARCHAR(500)
);

insert into playlist values('p1','asdasd','s1');

insert into playlist values('p2','assasd','s1');

DROP TABLE IF EXISTS Users;

CREATE TABLE Users(
user_id VARCHAR(30) PRIMARY KEY,
user_name VARCHAR(30),
email_id VARCHAR(30),
password VARCHAR(50),
gender VARCHAR(7),
pic_id VARCHAR(35),
playlist_ids VARCHAR(400),
dob DATE,
phone_no VARCHAR(15)
);

DROP TABLE IF EXISTS Artists;

CREATE TABLE Artists(
artist_id VARCHAR(30) PRIMARY KEY,
artist_name VARCHAR(50),
dob VARCHAR(15),
tenure_date VARCHAR(15),
brief_description VARCHAR(1500),
banner_pic VARCHAR(50),
portfolio_pic VARCHAR(50)
);

INSERT INTO ARTISTS VALUES('a1','Lata Mangeshkar','1929-09-28','','Lata Mangeshkar(born 28 September 1929) is an Indian playback singer and occasional music composer. She is the best-known and most respected playback singer in India.She is referred to as the Nightingale of India and the Queen of Melody. She is also known as the voice of the nation. Mangeshkar/''s career started in 1942 and has spanned over seven decades. She has recorded songs for over a thousand Hindi films and has sung songs in over thirty-six regional Indian languages and foreign languages, though primarily in Marathi and Hindi. She is the recipient of three National Film Awards, 12 Bengal Film Journalists/'' Association Awards, four Filmfare Best Female Playback Awards, two Filmfare Special Awards, Filmfare Lifetime Achievement Award and many more. The Dadasaheb Phalke Award was bestowed on her in 1989 by the Government of India. She is also the second vocalist, after M. S. Subbulakshmi, to have ever been awarded the Bharat Ratna in 2001, India/''s highest civilian honour.[4] She was the first Indian to perform in Royal Albert Hall in 1974. She was conferred France/''s highest civilian award (Officer of the Legion of Honour) in 2007. Due to all of her achievements, many singers and musicians consider her to be one of the greatest female singers in the Hindi film industry. She has four siblings—Asha Bhosle, Hridaynath Mangeshkar, Usha Mangeshkar and Meena Mangeshkar—of which she is the eldest.','a1_b1','a1_p1');

INSERT INTO ARTISTS VALUES('a2','Kishore Kumar','1929-08-04','1987-10-13','Kishore Kumar was an Indian playback singer, actor, lyricist, composer, producer, director, and screenwriter. He is considered one of the most successful playback singers in the Hindi film industry. Apart from Hindi, he sang in many Indian languages including Bengali, Marathi, Assamese, Gujarati, Kannada, Bhojpuri, Malayalam and Urdu. He has also sung in private albums in several languages especially in Bengali, which are noted as all time classics. He won 8 Filmfare Awards for Best Male Playback Singer and holds the record for winning the most Filmfare Awards in that category. He was awarded the "Lata Mangeshkar Award" by the Madhya Pradesh government in the year 1985-86. In the year 1997, the Madhya Pradesh Government initiated an award called the "Kishore Kumar Award" as a contribution to Hindi cinema. Recently, Kishore Kumar/''s unreleased last song was sold for Rs 15.6 lakh (1.56 million) at the Osian/''s Cinefan Auction, New Delhi in 2012.','a2_b1','a2_p1');


INSERT INTO ARTISTS VALUES('a3','Mohammed Rafi','1924-12-24','1980-06-31','Mohammed Rafi (24 December 1924 - 31 July 1980) was an Indian playback singer and one of the most popular and successful singers of the Hindi film industry. Rafi is widely considered to be one of the greatest singers of the Indian subcontinent. Rafi was notable for his voice and versatility; his songs ranged from fast peppy numbers to patriotic songs, sad numbers to highly romantic songs, qawwalis to ghazals and bhajans to classical songs. He was known for his ability to mould his voice to the persona and style of an actor, lip-syncing the song on screen in the movie. He received six Filmfare Awards and one National Film Award. In 1967, he was honoured with the Padma Shri award by the Government of India. He has recorded songs for over a thousand Hindi films and has sung songs in various regional Indian languages as well as foreign languages, though primarily in Hindi-Urdu and Punjabi over which he had a strong command. He has sung as many as 7405 songs in many languages.[6] He has sung in many regional Indian languages including Konkani, Assamese, Bhojpuri, Odia, Punjabi, Bengali, Marathi, Sindhi, Kannada, Gujarati, Tamil, Telugu, Magahi, Maithili. Apart from Indian languages, he also sang songs in many foreign languages including English, Farsi, Arabic, Sinhalese, Creole and Dutch.','a3_b1','a3_p1');

INSERT INTO ARTISTS VALUES('v1','Anonymous','-','','No Description Available','v1_b1','v1_p1');


DROP TABLE IF EXISTS Songs;

CREATE TABLE Songs(
song_id VARCHAR(20) PRIMARY KEY,
song_name VARCHAR(50),
artist_ids VARCHAR(200),
song_banner VARCHAR(50),
song_date VARCHAR(50),
song_gif_id VARCHAR(30),
song_length VARCHAR(10),
song_link VARCHAR(200),
song_mood VARCHAR(50),
song_language VARCHAR(20),
songs_movie VARCHAR(30)
);

insert into songs VALUES('s1','Lagjaa Gale Se','a1','s1_b1','1964','s1_gif1','4.17','https://s3-ap-northeast-1.amazonaws.com/ankitkumarlti/songs/','ROMANCE','HINDI','WOH KON THI');


insert into songs VALUES('s2','Ek Ajnabee Haseena Se','a2','s2_b1','1974','s2_gif1','4.08','https://s3-ap-northeast-1.amazonaws.com/ankitkumarlti/songs/','HAPPY','HINDI','AJNABEE');


insert into songs VALUES('s3','Teri Galiyon Mein Na Rakheinge','a3','s3_b1','1974','s3_gif1','4.32','https://s3-ap-northeast-1.amazonaws.com/ankitkumarlti/songs/','SAD','HINDI','HAWAS');


insert into songs VALUES('s4','Gayatri Mantra - Om Bhur Bhuva Swaha','v1','s4_b1','-','s4_gif1','9.31','https://s3-ap-northeast-1.amazonaws.com/ankitkumarlti/songs/','SPIRITUAL','HINDI','-');


DROP TABLE IF EXISTS Moods;
CREATE TABLE Moods(
mood_name VARCHAR(50)
);

INSERT INTO Moods VALUES('HAPPY');

INSERT INTO Moods VALUES('SAD');

INSERT INTO Moods VALUES('ROMANCE');

INSERT INTO Moods VALUES('GHAZAL');

INSERT INTO Moods VALUES('SPIRITUAL');


CREATE TABLE CountInf(

songs_count INTEGER(20),

artists_count INTEGER(20),

users_count INTEGER(20),

playlist_count INTEGER(20)

);


insert into count_Inf values(1,1,2,2);