package practice;

public class TestMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String searchedCabsPriceText[]= {
				"₹ 9,288",
				"₹ 13,902",
				"₹ 18,200"
		};
		System.out.println(searchedCabsPriceText.length);
		int[] convertedToInteger = new int[searchedCabsPriceText.length];
		
		int i = 0;
		for(String str:searchedCabsPriceText)
		{	
			String [] amtArray;
			if(str.length() >= 7) {
				amtArray = str.substring(2).split(",");
				convertedToInteger[i] = Integer.parseInt(amtArray[0]+amtArray[1]);
			} else {
				convertedToInteger[i] = Integer.parseInt(str.substring(2));;
			}
			System.out.println(convertedToInteger[i]);
			i++;
		}
		
	}

}
