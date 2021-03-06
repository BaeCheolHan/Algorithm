import java.text.Normalizer;

public class NormalizerTest {  
	public static void main(String[] args) {
		String han = "한";
        printIt(han);

        String nfd = Normalizer.normalize(han, Normalizer.Form.NFD);
        printIt(nfd);

        String nfc = Normalizer.normalize(nfd, Normalizer.Form.NFC);
        printIt(nfc);
		
	}
	
    private static void printIt(String string) {
        System.out.println(string);
        for (int i = 0; i < string.length(); i++) {
            System.out.print(String.format("U+%04X ", string.codePointAt(i)));
        }
        System.out.println();
    }

}