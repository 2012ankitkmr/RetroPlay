package retroplay.Helper;

public class HelperClass {

	// converts Stream of string from array of String
	public String convertStringArrayToString(String[] strArr, String delimiter) throws Exception {

		StringBuilder sb = new StringBuilder();
		try {
			for (String str : strArr) {
				if (str != null)
					sb.append(str).append(delimiter);
			}
			if (sb.length() >= 1)
				return sb.substring(0, sb.length() - 1);
			else
				return sb.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

}
