import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Transliterate_wiki {

    static String folder_path = "C://Users/pragya/Google Drive/OSU/4th Sem/cl2/Inuktitut-Transliteration-master/data/";

    public static List<String> getFileList(String directoryPath) {
        List<String> results = new ArrayList<String>();

        File[] files = new File(directoryPath).listFiles();

        if (files == null)
            return results;
        for (File file : files) {
            if (file.isFile()) {
                results.add(file.getName());
            }
        }

        return results;
    }

    public static void main(String[] args) throws IOException {

        List<String> filePaths = getFileList(folder_path + "wikipedia/");

        System.out.println(filePaths.size() + " ");
        filePaths.remove(".DS_Store");
        List<String> inukString = new ArrayList<>();
        List<String> transliteratedString;
        int count = 0;
        for (String file : filePaths) {
            transliteratedString = new ArrayList<>();
            Reader reader = new InputStreamReader(new FileInputStream(folder_path + "wikipedia/" + file), Charset.defaultCharset());
            Reader bufferReader = new BufferedReader(reader);
            String st;
            while ((st = ((BufferedReader) bufferReader).readLine()) != null) {
                transliteratedString.add(transcodeToRoman(st));
                count++;
            }
            writeToFiles(file, transliteratedString);
        }

        System.out.println("count : " + count + " files: " + filePaths.size());

    }

    private static void writeToFiles(String filename, List<String> transliteratedString) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(folder_path + "wiki_roman/"+ filename, true));

        for (String str : transliteratedString) {
            String mod = str.replaceAll("\\d", "");
            writer.append(mod);
            writer.append('\n');
        }

        writer.close();
    }

    static public String transcodeToRoman(String s) {
        int i = 0;
        int l = s.length();
        char c, e;
        String d;
        StringBuffer sb = new StringBuffer();
        while (i < l) {
            c = s.charAt(i);
            switch (c) {
                case '\u1403':
                    d = "i";
                    break;
                case '\u1431':
                    d = "pi";
                    break;
                case '\u144E':
                    d = "ti";
                    break;
                case '\u146D':
                    d = "ki";
                    break;
                case '\u148B':
                    d = "gi";
                    break;
                case '\u14A5':
                    d = "mi";
                    break;
                case '\u14C2':
                    d = "ni";
                    break;
                case '\u14EF':
                    d = "si";
                    break;
                case '\u14D5':
                    d = "li";
                    break;
                case '\u1528':
                    d = "ji";
                    break;
                case '\u1555':
                    d = "vi";
                    break;
                case '\u1546':
                    d = "ri";
                    break;
                case '\u157F':
                    d = "qi";
                    break;
                case '\u158F':
                    d = "ngi";
                    break;
                case '\u1671':
                    d = "nngi";
                    break;
                case '\u15A0':
                    d = "&i";
                    break;
                case '\u1405':
                    d = "u";
                    break;
                case '\u1433':
                    d = "pu";
                    break;
                case '\u1450':
                    d = "tu";
                    break;
                case '\u146F':
                    d = "ku";
                    break;
                case '\u148D':
                    d = "gu";
                    break;
                case '\u14A7':
                    d = "mu";
                    break;
                case '\u14C4':
                    d = "nu";
                    break;
                case '\u14F1':
                    d = "su";
                    break;
                case '\u14D7':
                    d = "lu";
                    break;
                case '\u152A':
                    d = "ju";
                    break;
                case '\u1557':
                    d = "vu";
                    break;
                case '\u1548':
                    d = "ru";
                    break;
                case '\u1581':
                    d = "qu";
                    break;
                case '\u1591':
                    d = "ngu";
                    break;
                case '\u1673':
                    d = "nngu";
                    break;
                case '\u15A2':
                    d = "&u";
                    break;
                case '\u140A':
                    d = "a";
                    break;
                case '\u1438':
                    d = "pa";
                    break;
                case '\u1455':
                    d = "ta";
                    break;
                case '\u1472':
                    d = "ka";
                    break;
                case '\u1490':
                    d = "ga";
                    break;
                case '\u14AA':
                    d = "ma";
                    break;
                case '\u14C7':
                    d = "na";
                    break;
                case '\u14F4':
                    d = "sa";
                    break;
                case '\u14DA':
                    d = "la";
                    break;
                case '\u152D':
                    d = "ja";
                    break;
                case '\u1559':
                    d = "va";
                    break;
                case '\u154B':
                    d = "ra";
                    break;
                case '\u1583':
                    d = "qa";
                    break;
                case '\u1593':
                    d = "nga";
                    break;
                case '\u1675':
                    d = "nnga";
                    break;
                case '\u15A4':
                    d = "&a";
                    break;
                case '\u1404':
                    d = "ii";
                    break;
                case '\u1432':
                    d = "pii";
                    break;
                case '\u144F':
                    d = "tii";
                    break;
                case '\u146E':
                    d = "kii";
                    break;
                case '\u148C':
                    d = "gii";
                    break;
                case '\u14A6':
                    d = "mii";
                    break;
                case '\u14C3':
                    d = "nii";
                    break;
                case '\u14F0':
                    d = "sii";
                    break;
                case '\u14D6':
                    d = "lii";
                    break;
                case '\u1529':
                    d = "jii";
                    break;
                case '\u1556':
                    d = "vii";
                    break;
                case '\u1547':
                    d = "rii";
                    break;
                case '\u1580':
                    d = "qii";
                    break;
                case '\u1590':
                    d = "ngii";
                    break;
                case '\u1672':
                    d = "nngii";
                    break;
                case '\u15A1':
                    d = "&ii";
                    break;
                case '\u1406':
                    d = "uu";
                    break;
                case '\u1434':
                    d = "puu";
                    break;
                case '\u1451':
                    d = "tuu";
                    break;
                case '\u1470':
                    d = "kuu";
                    break;
                case '\u148E':
                    d = "guu";
                    break;
                case '\u14A8':
                    d = "muu";
                    break;
                case '\u14C5':
                    d = "nuu";
                    break;
                case '\u14F2':
                    d = "suu";
                    break;
                case '\u14D8':
                    d = "luu";
                    break;
                case '\u152B':
                    d = "juu";
                    break;
                case '\u1558':
                    d = "vuu";
                    break;
                case '\u1549':
                    d = "ruu";
                    break;
                case '\u1582':
                    d = "quu";
                    break;
                case '\u1592':
                    d = "nguu";
                    break;
                case '\u1674':
                    d = "nnguu";
                    break;
                case '\u15A3':
                    d = "&uu";
                    break;
                case '\u140B':
                    d = "aa";
                    break;
                case '\u1439':
                    d = "paa";
                    break;
                case '\u1456':
                    d = "taa";
                    break;
                case '\u1473':
                    d = "kaa";
                    break;
                case '\u1491':
                    d = "gaa";
                    break;
                case '\u14AB':
                    d = "maa";
                    break;
                case '\u14C8':
                    d = "naa";
                    break;
                case '\u14F5':
                    d = "saa";
                    break;
                case '\u14DB':
                    d = "laa";
                    break;
                case '\u152E':
                    d = "jaa";
                    break;
                case '\u155A':
                    d = "vaa";
                    break;
                case '\u154C':
                    d = "raa";
                    break;
                case '\u1584':
                    d = "qaa";
                    break;
                case '\u1594':
                    d = "ngaa";
                    break;
                case '\u1676':
                    d = "nngaa";
                    break;
                case '\u15A5':
                    d = "&aa";
                    break;
                case '\u1449':
                    d = "p";
                    break;
                case '\u1466':
                    d = "t";
                    break;
                case '\u1483':
                    d = "k";
                    break;
                case '\u14A1':
                    d = "g";
                    break;
                case '\u14BB':
                    d = "m";
                    break;
                case '\u14D0':
                    d = "n";
                    break;
                case '\u1505':
                    d = "s";
                    break;
                case '\u14EA':
                    d = "l";
                    break;
                case '\u153E':
                    d = "j";
                    break;
                case '\u155D':
                    d = "v";
                    break;
                case '\u1550': // r
                    i++;
                    if (i < l) {
                        e = s.charAt(i);
                        switch (e) { // r+k. > q.
                            case '\u146D':
                                d = "qi";
                                break;
                            case '\u146F':
                                d = "qu";
                                break;
                            case '\u1472':
                                d = "qa";
                                break;
                            case '\u146E':
                                d = "qii";
                                break;
                            case '\u1470':
                                d = "quu";
                                break;
                            case '\u1473':
                                d = "qaa";
                                break;
                            case '\u146B':
                                d = "qai";
                                break;
                            default:
                                d = "r";
                                i--;
                                break;
                        }
                    } else {
                        i--;
                        d = "r";
                    }
                    break;
                case '\u1585': // q
                    i++;
                    if (i < l) {
                        e = s.charAt(i);
                        switch (e) { // q+k. > qq.
                            case '\u146D':
                                d = "qqi";
                                break;
                            case '\u146F':
                                d = "qqu";
                                break;
                            case '\u1472':
                                d = "qqa";
                                break;
                            case '\u146E':
                                d = "qqii";
                                break;
                            case '\u1470':
                                d = "qquu";
                                break;
                            case '\u1473':
                                d = "qqaa";
                                break;
                            case '\u146B':
                                d = "qqai";
                                break;
                            default:
                                d = "q";
                                i--;
                                break;
                        }
                    } else {
                        i--;
                        d = "q";
                    }
                    break;
                case '\u1595': // ng
                    i++;
                    if (i < l) {
                        e = s.charAt(i);
                        switch (e) { // ng+g. > ng.
                            case '\u148B':
                                d = "ngi";
                                break;
                            case '\u148D':
                                d = "ngu";
                                break;
                            case '\u1490':
                                d = "nga";
                                break;
                            case '\u148C':
                                d = "ngii";
                                break;
                            case '\u148E':
                                d = "nguu";
                                break;
                            case '\u1491':
                                d = "ngaa";
                                break;
                            case '\u1489':
                                d = "ngai";
                                break;
                            default:
                                d = "ng";
                                i--;
                                break;
                        }
                    } else {
                        i--;
                        d = "ng";
                    }
                    break;
                case '\u1596':
                    i++;
                    if (i < l) {
                        e = s.charAt(i);
                        switch (e) { // nng+g. > nng.
                            case '\u148B':
                                d = "nngi";
                                break;
                            case '\u148D':
                                d = "nngu";
                                break;
                            case '\u1490':
                                d = "nnga";
                                break;
                            case '\u148C':
                                d = "nngii";
                                break;
                            case '\u148E':
                                d = "nnguu";
                                break;
                            case '\u1491':
                                d = "nngaa";
                                break;
                            case '\u1489':
                                d = "nngai";
                                break;
                            default:
                                d = "nng";
                                i--;
                                break;
                        }
                    } else {
                        i--;
                        d = "nng";
                    }
                    break;
                case '\u15A6':
                    d = "&";
                    break;
                case '\u157C':
                    d = "H";
                    break; // Nunavut H
                case '\u1574':
                    d = "hai";
                    break; // Nunavik Hai
                case '\u1575':
                    d = "hi";
                    break; // Nunavik Hi
                case '\u1576':
                    d = "hii";
                    break; // Nunavik Hii
                case '\u1577':
                    d = "hu";
                    break; // Nunavik Hu
                case '\u1578':
                    d = "huu";
                    break; // Nunavik Huu
                case '\u1579':
                    d = "ha";
                    break; // Nunavik Ha
                case '\u157A':
                    d = "haa";
                    break; // Nunavik Haa
                case '\u15AF':
                    d = "b";
                    break; // Aivilik B
                case '\u1401':
                    d = "ai";
                    break; // ai
                case '\u142f':
                    d = "pai";
                    break; // pai
                case '\u144c':
                    d = "tai";
                    break; // tai
                case '\u146b':
                    d = "kai";
                    break; // kai
                case '\u1489':
                    d = "gai";
                    break; // gai
                case '\u14a3':
                    d = "mai";
                    break; // mai
                case '\u14c0':
                    d = "nai";
                    break; // nai
                case '\u14ed':
                    d = "sai";
                    break; // sai
                case '\u14d3':
                    d = "lai";
                    break; // lai
                case '\u1526':
                    d = "jai";
                    break; // jai
                case '\u1553':
                    d = "vai";
                    break; // vai
                case '\u1543':
                    d = "rai";
                    break; // rai
                case '\u1542':
                    d = "rai";
                    break; // rai
                case '\u166f':
                    d = "qai";
                    break; // qai
                case '\u1670':
                    d = "ngai";
                    break;  // ngai
                default:
                    d = new String(new char[]{c});
                    break;
            }
            i++;
            sb.append(d);
        }
        return sb.toString();
    }
}
