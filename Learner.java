package learner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;

class Learner { 
	InputStream inflow;
	int Δ;
	
	int[] duce;//pair, score
	//static int[][] olpairs, nupairs;//arrayList of scored pairs
	HashMap<String, Integer> duces = new HashMap<>();
	
	int[][] quartet;//quad, score ... [[duce,duce], [score]]
	//static int[][][] olquads, nuquads;//arrayList of scored quads
	HashMap<String, Integer> fours = new HashMap<>();
	
	int[][][] eightball;//8ball, score... [[quartet, quartet], [score]]...[[[pair,pair],[pair,pair]], [[score]]]
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
    		lrnr.Δ = (char)lrnr.inflow.read();
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
	
	int twoδ;
	int duceduce[];
	int quartettwo[][];


	void consume(int δ){
		retryδ:
		try{
            if(duces.get(Arrays.toString(duce = new int[]{(char)twoδ, (char)δ})) !=null)
            	duces.put(Arrays.toString(duce), duces.get(Arrays.toString(duce))+1);
            else
            	duces.put(Arrays.toString(duce), 1);
            System.out.format("%c%c%d\n", duce[0], duce[1], duces.get(Arrays.toString(duce)));
        }catch(Exception e){
            e.printStackTrace();
        }
		twoδ = δ;
        
		retryduce:
        try{
            if(fours.get(Arrays.toString(quartet = new int[][] {duceduce, duce}))!=null)
            	fours.put(Arrays.toString(quartet), fours.get(Arrays.toString(quartet))+1);
            else
            	fours.put(Arrays.toString(quartet), 1);
            System.out.format("%c%c%c%c%d\n", quartet[0][0],quartet[0][1], quartet[1][0], quartet[1][1], fours.get(Arrays.toString(quartet)));
        }catch(Exception e){
            //e.printStackTrace();
        }
        duceduce = duce;
        
        retryquart:
    	try{
            if(eights.containsKey(eightball = new int[][][] {quartettwo, quartet}))
            	eights.put(Arrays.toString(eightball), eights.get(Arrays.toString(eightball))+1);
            else
            	eights.put(Arrays.toString(eightball), 1);
            System.out.format("%c%c%c%c%c%c%c%c%d\n", eightball[0][0][0],eightball[0][0][1], eightball[0][1][0], eightball[0][1][1], eightball[1][0][0], eightball[1][0][1], eightball[1][1][0], eightball[1][1][1],  eights.get(Arrays.toString(eightball)));
        }catch(Exception e){
            //e.printStackTrace();
        }
        quartettwo = quartet;
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
