import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;

class Learner { 
	InputStream inflow;
	byte Δ;
	
	byte[] deuce;//pair, score
	//static int[][] olpairs, nupairs;//arrayList of scored pairs
	HashMap<String, Integer> deuces = new HashMap<>();
	
	byte[] square;//quad, score ... [[duce,duce], [score]]
	//static int[][][] olquads, nuquads;//arrayList of scored quads
	HashMap<String, Integer> fours = new HashMap<>();
	
	byte[] octet;//8ball, score... [[quartet, quartet], [score]]...[[[pair,pair],[pair,pair]], [[score]]]
	HashMap<String, Integer> eights  = new HashMap<>();
	
	Learner(){
		try {
			this.inflow = new FileInputStream("/Users/johnearley/eclipse-workspace/IOE/Learner/SavedMemory");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
    public static void main(String[] JohnEarley) throws Exception {
        Learner lrnr = new Learner();
    	System.out.println("Reader started...");   

    	while(lrnr.Δ != -1) {
    		lrnr.Δ = (byte)lrnr.inflow.read();
        	lrnr.consume(lrnr.Δ);
    	}
    	
    	System.out.println("Done.");
       
    }
    
//	String getDoc(String fle) throws IOException {
//		String reading = "";
//		File file = new File("/Users/johnearley/eclipse-workspace/IOE/Learner/" + fle); 
//		  
//		BufferedReader br = new BufferedReader(new FileReader(file)); 
//		
//		String st;
//		while ((st = br.readLine()) != null) 
//			reading += st;
//		return reading;
//	}
	
	byte Δ2;
	byte deucedeuce[];
	byte squaredsquare[];


	void consume(byte Δ1){
		try{
            if(deuces.containsKey(Arrays.toString(deuce = new byte[]{Δ2, Δ1})))
            	deuces.put(Arrays.toString(deuce), deuces.get(Arrays.toString(deuce))+1);
            else
            	deuces.put(Arrays.toString(deuce), 1);
            System.out.format("%c%c%d\n", (char)deuce[0], (char)deuce[1], deuces.get(Arrays.toString(deuce)));
        }catch(Exception e){
            e.printStackTrace();
        }
		Δ2 = Δ1;
        
        try{
            if(fours.containsKey(Arrays.toString(square = new byte[] {deucedeuce[0], deucedeuce[1], deuce[0], deuce[1]})))
            	fours.put(Arrays.toString(square), fours.get(Arrays.toString(square))+1);
            else
            	fours.put(Arrays.toString(square), 1);
            System.out.format("%c%c%c%c%d\n", (char)square[0], (char)square[1], (char)square[2], (char)square[3], fours.get(Arrays.toString(square)));
        }catch(Exception e){
            //e.printStackTrace();
        }
        deucedeuce = deuce;
        
    	try{
            if(eights.containsKey(Arrays.toString(octet = new byte[]{squaredsquare[3], squaredsquare[2], squaredsquare[1], squaredsquare[0], square[3], square[2], square[1], square[0]})))
            	eights.put(Arrays.toString(octet), eights.get(Arrays.toString(octet))+1);
            else
            	eights.put(Arrays.toString(octet), 1);
            System.out.format("%c%c%c%c%c%c%c%c%d\n", (char)octet[0], (char)octet[1], (char)octet[2], (char)octet[3], (char)octet[4], (char)octet[5], (char)octet[6], (char)octet[7],  eights.get(Arrays.toString(octet)));
        }catch(Exception e){
            //e.printStackTrace();
        }
        squaredsquare = square;
    }
    
    
//    static int quadUp(int[][] twopair){
//    	try {
//			for(int i = 0;i < olquads.length; i++) {
//				if(olquads[i] == twopair)
//					return ++olquads[i][2][0];
//			}
//
//			nuquads = new int[olquads.length][][];
//            for(int i = 0; i < nuquads.length; i++)
//                nuquads[i] = olquads[i];
//            
//            nuquads[olquads.length] = new int[][]{twopair[0], twopair[1], {1}};
//            olquads = nuquads;
//            return nuquads[nuquads.length-1][2][0];
//    	}catch(Exception e) {
//    		olquads = new int [1][][];
//    		olquads[0] = new int[][] {twopair[0], twopair[1], {0}};
//    		quadUp(olquads[0]);
//    	}
//    	return -1; 
//    }
}

	

//    static int addPair(int[] pair){
//    	retry:
//            try{
//                for(int i = 0; i < olpairs.length; i++){
//                    if(olpairs[i][0] == pair[0] && olpairs[i][1] == pair[1])
//                       return ++olpairs[i][2];
//                }
//                
//                nupairs = new int[olpairs.length + 1][];
//                for(int i = 0; i < olpairs.length; i++)
//                    nupairs[i] = olpairs[i];
//                
//                nupairs[olpairs.length] = new int[]{pair[0], pair[1], 1};
//            	//int q = quadUp(new int[][] {nupairs[olpairs.length], olpairs[olpairs.length-1], new int[] {1}});
//            	olpairs = nupairs;
//            	return nupairs[nupairs.length-1][2];
//            }catch(Exception e){
//                olpairs = new int[1][];
//                olpairs[0] = new int[]{pair[0], pair[1], 0};
//                break retry;
//            }
//         
//        return -1;
//    }
//    
//    
//    static int quadUp(int[][] twopair){
//    	try {
//			for(int i = 0;i < olquads.length; i++) {
//				if(olquads[i] == twopair)
//					return ++olquads[i][2][0];
//			}
//
//			nuquads = new int[olquads.length][][];
//            for(int i = 0; i < nuquads.length; i++)
//                nuquads[i] = olquads[i];
//            
//            nuquads[olquads.length] = new int[][]{twopair[0], twopair[1], {1}};
//            olquads = nuquads;
//            return nuquads[nuquads.length-1][2][0];
//    	}catch(Exception e) {
//    		olquads = new int [1][][];
//    		olquads[0] = new int[][] {twopair[0], twopair[1], {0}};
//    		quadUp(olquads[0]);
//    	}
//    	return -1; 
//    }
//}

    	
//    	if(i < 0 && i < 9) {
	//    		queue[i++] = pairOScoredPairs;
	//    	}
//    	}
//    	
//    	return output;
//    }
//    	//tac on new
//    	//out first
//    	//shift forward
//    	
//    	if(i < 9) {
//    		queue = queue == null ? new int[9][3] : queue;
//    		queue[i++] = scoredPair;
//    	}
//    	
//    	
//    	
//
//    	
//    	retry:
//            try{
//                for(int i = 0; i < oldQuads.length; i++){//go throught list
//                	for(int j = 0; j < oldQuads[i].length; j++) {
//                		if(oldQuads[i][j][0] == scoredPair[0] && oldQuads[i][j][1] == ipair[1])
//                            return ++oldQuads[i][2];
//                	}
//                    
//                }
//                
//                newpairs = new int[oldQuads.length + 1][ipair.length + 1];
//                for(int i = 0; i < oldQuads.length; i++)
//                    newpairs[i] = oldQuads[i];
//                
//                newpairs[oldQuads.length] = new int[]{ipair[0], ipair[1], 1};      
//                oldQuads = newpairs;
//                return newpairs[newpairs.length-1][2];
//            }catch(Exception e){
//                oldQuads = new int[1][3];
//                oldQuads[0] = new int[]{ipair[0], ipair[1], 0};
//                break retry;
//            }
//    	
//    	
//        return -1;
//    }
//}
	
//	//Equipment
//	Memory memory;
//	BufferedWriter writer;
//	String buffer = "";
//	ArrayList<ArrayList<Character>> CharState = new ArrayList<>();
//	int buffr = 0;
	
	
//	public String CharState(char a) throws Exception {
//		CharState.
//		
//		
//		
//		
////		if(CharState.isEmpty()) {
////			P=P;
////			a10+=a;
////			D=D;
////			B=B;
////			CharState += P+a10+D+B;
////		}
////		else {
////			//increment the P
////			buffer = "";
////			
////			for(char i: pcharray = CharState.toCharArray()) {
////				if(i == buffer.charAt(++buffr))//Find the last char of {
////					pcharray[++buffr] = (char) (1 + Integer.parseInt(String.valueOf(pcharray[buffr])));//turn char into a int, increment, and back to char
////				}
////			}
////			P+=pcharray[--buffr]+pcharray[--buffr]+pcharray[buffr]+"|";
////			a10+=a; 
////			D=D;
////			B=B;
////			CharState += P+a10+D+B;
////		}
//	}
	
	//Requirment
	//String req = Read("Requirement");
//	public Learner() throws Exception{
//		memory = new Memory(this);
//		writer = new BufferedWriter(new FileWriter("/Users/johnearley/eclipse-workspace/IOE/Learner/Memory"));
//	}
//	
//	public static void Write(String to, String what) throws IOException {
//		writer = new BufferedWriter(new FileWriter("/Users/johnearley/eclipse-workspace/IOE/Learner/Memory"));
//		writer.append(what);
//		writer.close();
//	}
//
//	public void test1(String str) throws IOException {//test1:put memory in
//
//		this.Write("Memory", "/"+ str + "|");
//	}
//	
//	public String test2() throws IOException {//
//		String s = this.Read("Memory");
//		String[] rels = this.Read("Interpretted").split("*");
//		s = "";
//		int relevance = 0;
//		for(int r = 0; r < rels.length; r++) {
//			for(char c: rels[r].toCharArray()) {
//				if("/".equals(Character.toString(c))){
//					relevance++;
//					//remove / later
//				}
//			}
//			s+=rels[r] + " rel: " + relevance;
//		}
//		
//		return s;
//	}
//	
//	public static String Read(String fle) throws IOException {
//		String reading = "";
//		File file = new File("/Users/johnearley/eclipse-workspace/IOE/Learner/" + fle); 
//		  
//		BufferedReader br = new BufferedReader(new FileReader(file)); 
//		
//		String st;
//		while ((st = br.readLine()) != null) 
//			reading += st;
//		return reading;
//	}
//	
//	public int getWordIndex(String[] words, String word) {
//		for(int i = 0; i<words.length; i++) {
//			if(words[i].equals(word))
//				return i;
//		}
//		return -1;
//	}
//	
//	public String getWordInfo(String str) {
//		String str1 = "";
//		
//		return str1;
//	}
//	String sta[];
//	String stb = "";
//	public String showRelations() throws IOException {//show relations
//		String s = "";
//		sta  = this.Read("Memory").split("/");
//		for(String str: sta) {
//		   s += str.replace("-", "50");
//		}
//		return s;
//	}
//	
////	public static String StringSimilarity(Object o1, Object o2) {
////		char[] o1 = o1.toCharArray(), o2 = o2.toCharArray();
////		
////		System.out.println(o1.getClass().getSimpleName()):
////		System.out.println(o2.getClass().getSimpleName()):
////	}
//	
//	//needs to listen to sounds and regenerate with understood changing points -> simple 10 x,y coors for each letter add inexactness for fun 
//	
//	//Get a different voice for each letter, take the mean from the generation sigma, get unique voice, that will now create difference from self to others
//	//talking will be like going to the movies... rare and entertaining...purpose: status update
//	
//	
//	//graph will x0-1,y0-1 so to connect with RELATIONS
//	
//	public static int[] getRand() {
//		return Long.toString(System.currentTimeMillis()/System.nanoTime()).getints();
//	}
//
//	public void preserve(String where) throws IOException {
//		Write(where, this.memory.unPack());
//	}	
//	
//	//speak(to who(later), what) // just speak all can hear
//	
//	//listen(event handler for someone speaking, remember all for now(but should generate different relations))
//	
//	//can compare others and to self
//	
//	public static void main(String[]args) throws Exception {
//		Learner lrnr = new Learner();
//		
//		//lrnr.CharState.add(e)
//		
////		String[] reqs = Read("Requirement").split(" ");
////		for(String req: reqs) {
////			String[] words = req.split(" ");
////			for(int i = 0; i< words.length; i++) {
////				lrnr.Write("Memory", words[i]+"|"+words[++i]+",");
////			}
////		}
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		String m = "!: ";
//		while(!m.contains("!")) {
//			System.out.println("waiting for input...\n");
//			m += "/-"+reader.readLine()+"|";
//			lrnr.test1(m);
//			System.out.println("Here is the memory: \n"  + m );
//			//System.out.println("Here would be a deduction(later):");
//		}
//		System.out.println(lrnr.test2());
//		//
//		
//	}
//	
//	
//}
