//Leetcode problem 792 Number of Matching Subsequences
//Solution written by Xuqiang Fang on 4 March 2018
//answer for the test case should be 50

import java.util.HashMap;
import java.util.Map;

class Solution{
	public int numMatchingSubseq(String S, String[] words){
		int count = 0;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0; i<S.length(); i++){
			String temp = S.substring(i,i+1);
			int x = map.getOrDefault(temp,0)+1;
			map.put(temp, x);
		}
		System.out.println(map);	
		for(int i=0; i<words.length; i++){
			Map<String, Integer> wordMap = new HashMap<String, Integer>();
			for(int j=0; j<words[i].length(); j++){
				String t = words[i].substring(j,j+1);
				int y = wordMap.getOrDefault(t,0)+1;
				wordMap.put(t,y);
			}
			boolean flag = true;
			for(Map.Entry<String, Integer> entry : wordMap.entrySet()){
				String k = entry.getKey();
				Integer value = entry.getValue();
				if(!map.containsKey(k) || map.get(k)<value){
					flag = false;
					break;
				}
			}
			if(flag)
				count++;
		}
		return count;	
	}	
}

public class MatchSub{
	public static void main(String[] args){
		Solution s = new Solution();
		String str = "ricogwqznwxxcpueelcobbbkuvxxrvgyehsudccpsnuxpcqobtvwkuvsubiidjtccoqvuahijyefbpqhbejuisksutsowhufsygtwteiqyligsnbqglqblhpdzzeurtdohdcbjvzgjwylmmoiundjscnlhbrhookmioxqighkxfugpeekgtdofwzemelpyjsdeeppapjoliqlhbrbghqjezzaxuwyrbczodtrhsvnaxhcjiyiphbglyolnswlvtlbmkrsurrcsgdzutwgjofowhryrubnxkahocqjzwwagqidjhwbunvlchojtbvnzdzqpvrazfcxtvhkruvuturdicnucvndigovkzrqiyastqpmfmuouycodvsyjajekhvyjyrydhxkdhffyytldcdlxqbaszbuxsacqwqnhrewhagldzhryzdmmrwnxhaqfezeeabuacyswollycgiowuuudrgzmwnxaezuqlsfvchjfloczlwbefksxsbanrektvibbwxnokzkhndmdhweyeycamjeplecewpnpbshhidnzwopdjuwbecarkgapyjfgmanuavzrxricbgagblomyseyvoeurekqjyljosvbneofjzxtaizjypbcxnbfeibrfjwyjqrisuybfxpvqywqjdlyznmojdhbeomyjqptltpugzceyzenflfnhrptuugyfsghluythksqhmxlmggtcbdddeoincygycdpehteiugqbptyqbvokpwovbnplshnzafunqglnpjvwddvdlmjjyzmwwxzjckmaptilrbfpjxiarmwalhbdjiwbaknvcqovwcqiekzfskpbhgxpyomekqvzpqyirelpadooxjhsyxjkfqavbaoqqvvknqryhotjritrkvdveyapjfsfzenfpuazdrfdofhudqbfnzxnvpluwicurrtshyvevkriudayyysepzqfgqwhgobwyhxltligahroyshfndydvffd";
		String[] words = new String[]{"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","iowuuudrgzmw","azfcxtvhkruvuturdicnucvndigovkzrq","ylmmo","maptilrbfpjxiarmwalhbd","oqvuahijyefbpqhbejuisksutsowhufsygtwteiqyligsnbqgl","ytldcdlxqbaszbuxsacqwqnhrewhagldzhr","zeeab","cqie","pvrazfcxtvhkruvuturdicnucvndigovkzrqiya","zxnvpluwicurrtshyvevkriudayyysepzq","wyhxltligahroyshfn","nhrewhagldzhryzdmmrwn","yqbvokpwovbnplshnzafunqglnpjvwddvdlmjjyzmw","nhrptuugyfsghluythksqhmxlmggtcbdd","yligsnbqglqblhpdzzeurtdohdcbjvzgjwylmmoiundjsc","zdrfdofhudqbfnzxnvpluwicurrtshyvevkriudayyysepzq","ncygycdpehteiugqbptyqbvokpwovbnplshnzafun","gdzutwgjofowhryrubnxkahocqjzww","eppapjoliqlhbrbgh","qwhgobwyhxltligahroys","dzutwgjofowhryrubnxkah","rydhxkdhffyytldcdlxqbaszbuxs","tyqbvokpwovbnplshnzafunqglnpjvwddvdlmjjyzmwwxzjc","khvyjyrydhxkdhffyytldcdlxqbasz","jajekhvyjyrydhxkdhffyytldcdlxqbaszbuxsacqwqn","ppapjoliqlhbrbghq","zmwwxzjckmaptilrbfpjxiarm","nxkahocqjzwwagqidjhwbunvlchoj","ybfxpvqywqjdlyznmojdhbeomyjqptltp","udrgzmwnxae","nqglnpjvwddvdlmjjyzmww","swlvtlbmkrsurrcsgdzutwgjofowhryrubn","hudqbfnzxnvpluwicurr","xaezuqlsfvchjf","tvibbwxnokzkhndmdhweyeycamjeplec","olnswlvtlbmkrsurrcsgdzu","qiyastqpmfmuouycodvsyjajekhvyjyrydhxkdhffyyt","eiqyligsnbqglqblhpdzzeurtdohdcbjvzgjwyl","cgiowuuudrgzmwnxaezuqlsfvchjflocz","rxric","cygycdpehteiugqbptyqbvokpwovbnplshnzaf","g","surrcsgd","yzenflfnhrptuugyfsghluythksqh","gdzutwgjofowhryrubnxkahocqjzwwagqid","ddeoincygycdpeh","yznmojdhbeomyjqptltpugzceyzenflfnhrptuug","ejuisks","teiqyligsnbqglqblhpdzzeurtdohdcbjvzgjwylmmoi","mrwnxhaqfezeeabuacyswollycgio","qfskkpfakjretogrokmxemjjbvgmmqrfdxlkfvycwalbdeumav","wjgjhlrpvhqozvvkifhftnfqcfjmmzhtxsoqbeduqmnpvimagq","ibxhtobuolmllbasaxlanjgalgmbjuxmqpadllryaobcucdeqc","ydlddogzvzttizzzjohfsenatvbpngarutztgdqczkzoenbxzv","rmsakibpprdrttycxglfgtjlifznnnlkgjqseguijfctrcahbb","pqquuarnoybphojyoyizhuyjfgwdlzcmkdbdqzatgmabhnpuyh","akposmzwykwrenlcrqwrrvsfqxzohrramdajwzlseguupjfzvd","vyldyqpvmnoemzeyxslcoysqfpvvotenkmehqvopynllvwhxzr","ysyskgrbolixwmffygycvgewxqnxvjsfefpmxrtsqsvpowoctw","oqjgumitldivceezxgoiwjgozfqcnkergctffspdxdbnmvjago","bpfgqhlkvevfazcmpdqakonkudniuobhqzypqlyocjdngltywn","ttucplgotbiceepzfxdebvluioeeitzmesmoxliuwqsftfmvlg","xhkklcwblyjmdyhfscmeffmmerxdioseybombzxjatkkltrvzq","qkvvbrgbzzfhzizulssaxupyqwniqradvkjivedckjrinrlxgi","itjudnlqncbspswkbcwldkwujlshwsgziontsobirsvskmjbrq","nmfgxfeqgqefxqivxtdrxeelsucufkhivijmzgioxioosmdpwx","ihygxkykuczvyokuveuchermxceexajilpkcxjjnwmdbwnxccl","etvcfbmadfxlprevjjnojxwonnnwjnamgrfwohgyhievupsdqd","ngskodiaxeswtqvjaqyulpedaqcchcuktfjlzyvddfeblnczmh","vnmntdvhaxqltluzwwwwrbpqwahebgtmhivtkadczpzabgcjzx","yjqqdvoxxxjbrccoaqqspqlsnxcnderaewsaqpkigtiqoqopth","wdytqvztzbdzffllbxexxughdvetajclynypnzaokqizfxqrjl","yvvwkphuzosvvntckxkmvuflrubigexkivyzzaimkxvqitpixo","lkdgtxmbgsenzmrlccmsunaezbausnsszryztfhjtezssttmsr","idyybesughzyzfdiibylnkkdeatqjjqqjbertrcactapbcarzb","ujiajnirancrfdvrfardygbcnzkqsvujkhcegdfibtcuxzbpds","jjtkmalhmrknaasskjnixzwjgvusbozslrribgazdhaylaxobj","nizuzttgartfxiwcsqchizlxvvnebqdtkmghtcyzjmgyzszwgi","egtvislckyltpfogtvfbtxbsssuwvjcduxjnjuvnqyiykvmrxl","ozvzwalcvaobxbicbwjrububyxlmfcokdxcrkvuehbnokkzala","azhukctuheiwghkalboxfnuofwopsrutamthzyzlzkrlsefwcz","yhvjjzsxlescylsnvmcxzcrrzgfhbsdsvdfcykwifzjcjjbmmu","tspdebnuhrgnmhhuplbzvpkkhfpeilbwkkbgfjiuwrdmkftphk","jvnbeqzaxecwxspuxhrngmvnkvulmgobvsnqyxdplrnnwfhfqq","bcbkgwpfmmqwmzjgmflichzhrjdjxbcescfijfztpxpxvbzjch","bdrkibtxygyicjcfnzigghdekmgoybvfwshxqnjlctcdkiunob","koctqrqvfftflwsvssnokdotgtxalgegscyeotcrvyywmzescq","boigqjvosgxpsnklxdjaxtrhqlyvanuvnpldmoknmzugnubfoa","jjtxbxyazxldpnbxzgslgguvgyevyliywihuqottxuyowrwfar","zqsacrwcysmkfbpzxoaszgqqsvqglnblmxhxtjqmnectaxntvb","izcakfitdhgujdborjuhtwubqcoppsgkqtqoqyswjfldsbfcct","rroiqffqzenlerchkvmjsbmoybisjafcdzgeppyhojoggdlpzq","xwjqfobmmqomhczwufwlesolvmbtvpdxejzslxrvnijhvevxmc","ccrubahioyaxuwzloyhqyluwoknxnydbedenrccljoydfxwaxy","jjoeiuncnvixvhhynaxbkmlurwxcpukredieqlilgkupminjaj","pdbsbjnrqzrbmewmdkqqhcpzielskcazuliiatmvhcaksrusae","nizbnxpqbzsihakkadsbtgxovyuebgtzvrvbowxllkzevktkuu","hklskdbopqjwdrefpgoxaoxzevpdaiubejuaxxbrhzbamdznrr","uccnuegvmkqtagudujuildlwefbyoywypakjrhiibrxdmsspjl","awinuyoppufjxgqvcddleqdhbkmolxqyvsqprnwcoehpturicf"};
		System.out.println(words.length);
		System.out.println(s.numMatchingSubseq(str, words));
		//print(words);
	}
	public static void print(String[] s){
		for(int i=0; i<s.length; i++){
			System.out.println(s[i]);
		}
	}
}
