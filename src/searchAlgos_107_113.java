import java.io.*;
import java.util.*;

public class searchAlgos_107_113{
	static int source,dest,ch;
	public static void main(String args[]) throws Exception{
		MapOfRomania map=new MapOfRomania();
		map.displayMap();
                
                Scanner sc=new Scanner(System.in);
                
                String SourceName=sc.next();
                String DestName=sc.next();
                
                source=map.locationNames.indexOf(SourceName);
                dest=map.locationNames.indexOf(DestName);
                
                //bfs(map);
                AStar(map);
        }
	
        static void bfs(MapOfRomania map)
        {
            int list[][]=map.distances;
            int no_of_nodes=map.locationNames.size();
            
            Node root=new Node();
            
            root.setId(source);
            root.setName(map.locationNames.elementAt(source));
            root.setParent(null);
            
            Vector visited=new Vector();
            Vector toBeVisited=new Vector();
            Vector <Node>toBeVisitedNode=new Vector<Node>();
            int currentVisiting=source;
            toBeVisitedNode.add(root);
            Node currentNode;
            currentNode=root;
//          toBeVisited.add(currentVisiting);
            while(currentVisiting!=dest&&visited.size()<no_of_nodes)
            {
                
                System.out.println("Current Node Visited:"+currentVisiting);
                if(currentVisiting==dest)
                {
                    System.out.println("Node found");
                    break;
                }
                visited.add(currentVisiting);
                for(int i=0;i<no_of_nodes;i++)
                {
                    if(list[currentVisiting][i]==1&&!visited.contains(i)&&!toBeVisited.contains(i))
                    {
                        Node child=new Node();
                        child.setId(i);
                        child.setName(map.locationNames.elementAt(currentVisiting));
                        child.setParent(currentNode);
                        currentNode.Children.add(child);
                        toBeVisited.add(i);
                    }
                }
                
                //System.out.println(toBeVisited);
                
                int nextNode=dequeue(toBeVisited);
                if(nextNode==-1)
                    break;
                else
                {
                    currentVisiting=nextNode;
                    currentNode=toBeVisitedNode.elementAt(0);
                }
            }
            if(currentVisiting!=dest)
                System.out.println("Node not found!");
            else
                System.out.println("Node Found");
        }
        
        static void AStar(MapOfRomania map){
            int list[][]=map.distances;
            int no_of_nodes=map.locationNames.size();
            
            /**
             * These will hold location no
             */
            Vector<Integer> visitedList=new Vector<Integer>();
            Vector<Integer> adjNodesList=new Vector<Integer>();
                        
            /**
             * These are used to keep objects
             * These will hold distance from source values and parent reference
             */
            Vector<Node> visitedListNodes=new Vector<Node>();
            Vector<Node> adjNodesListNodes=new Vector<Node>();
            
            int currentVisiting=source;
            visitedList.add(source);
            visitedListNodes.add(new Node(null,0,map.locationNames.get(source),source));
            
            while(currentVisiting!=dest&&visitedList.size()<no_of_nodes)
            {
                if(currentVisiting==dest)
                {
                    System.out.println("Node found");
                    break;
                }
                
                for(int i=0;i<no_of_nodes;i++)
                {
                    if(list[currentVisiting][i]>0&&!visitedList.contains(i)&&!adjNodesList.contains(i)){
                        adjNodesList.add(i);
                        
                        /**
                         * Add Node object to adjNodesListNodes
                         * First, the parent Node reference in visitedListNodes is found
                         * This is used for calculating the distance of the adjacent nodes from source and to store the parent reference in this node
                         */
                        Node curNodeInVisited=visitedListNodes.get(visitedList.indexOf(currentVisiting));
                        adjNodesListNodes.add(new Node(curNodeInVisited,
                                                list[currentVisiting][i]+curNodeInVisited.distanceFromSource,
                                                map.locationNames.get(i),i) );
                        System.out.print("");
                    }
                }
                
                System.out.print("Visited Nodes List: ");
                displayVectorLocationNames(visitedList, map);
                
                System.out.print("Adjacent Nodes List: ");
                displayVectorLocationNames(adjNodesList, map);
                
                
                int minCost=9999999,tempCurrVisiting=-1;
                
                /**
                 * Here i,tempCurrVisiting is not location No but rather index of Node in vector
                 */
                System.out.println("Adjacent Nodes Costs:");
                for(int i=0;i<adjNodesList.size();i++){
                    int distFrmSrc=adjNodesListNodes.get(i).distanceFromSource;
                    int heur=map.locationHeuristics.get(adjNodesListNodes.get(i).id);
                    int totalCostOfNode=distFrmSrc+heur;
                    System.out.println(adjNodesListNodes.get(i).name+" -> "+distFrmSrc+" + "+heur+" = "+totalCostOfNode);
                    
                    if(totalCostOfNode<minCost){
                        minCost=totalCostOfNode;
                        tempCurrVisiting=i;
                    }
                }
                
                /**
                 * The next node is selected based on heuristics and distance from source to this node.
                 * This node is removed from adjacent nodes list and added to visited list.
                 */
                currentVisiting=adjNodesList.remove(tempCurrVisiting);
                Node selectedNode=adjNodesListNodes.remove(tempCurrVisiting);
                visitedList.add(currentVisiting);
                visitedListNodes.add(selectedNode);
                
                System.out.println("Minimum cost node chosen for next iteration: "+map.locationNames.get(currentVisiting)+"\n");
                
            }
        }
        
	static int dequeue(Vector v)
        {
            if(v.size()>0)
                return (int)v.remove(0);
            else
                return -1;
        }
        
        static void displayVectorLocationNames(Vector<Integer> v,MapOfRomania map){
            System.out.print("{ ");
            for(int i=0;i<v.size();i++){
                System.out.print(map.locationNames.get(v.get(i)));
                if(i!=v.size()-1){
                    System.out.print(", ");
                }
            }
            System.out.println(" }");
        }
}

class MapOfRomania{
    Vector<String> locationNames=new Vector<String>();
    Vector<Integer> locationHeuristics=new Vector<Integer>();
    int distances[][];
        
    public static final String MAP_PROPERTIES_FILE_PATH="F:\\OneDrive\\Projects\\Netbeans Projects\\searchAlgosAI\\src\\MapProperties.txt";
    public static final String MAP_HEURISTICS_FILE_PATH="F:\\OneDrive\\Projects\\Netbeans Projects\\searchAlgosAI\\src\\MapHeuristics.txt";

    public MapOfRomania() throws FileNotFoundException,IOException{
        
        BufferedReader brProps=new BufferedReader(new FileReader(MAP_PROPERTIES_FILE_PATH));
        BufferedReader brHeurs=new BufferedReader(new FileReader(MAP_HEURISTICS_FILE_PATH));
              
        String line;
        
        /**
         * This loop reads the heuristics and 
         * stores both the names of the locations and the heuristics
         */
        while((line=brHeurs.readLine())!=null){
            StringTokenizer st=new StringTokenizer(line);
            locationNames.add(st.nextToken());
            locationHeuristics.add(Integer.parseInt(st.nextToken()));
        }
        
        distances=new int[locationNames.size()][locationNames.size()];
        
        
        /**
         * This loop reads the properties file and stores the distances between all the locations
         */
        while((line=brProps.readLine())!=null){
            StringTokenizer st=new StringTokenizer(line);
            
            String source=st.nextToken();
            String dest=st.nextToken();
            int dist=Integer.parseInt(st.nextToken());
            
            if(locationNames.indexOf(source)==-1){
                System.out.println(source);
            }
            if(locationNames.indexOf(dest)==-1){
                System.out.println(dest);
            }
            distances[locationNames.indexOf(source)][locationNames.indexOf(dest)]=dist;
        }
    }
	
    
    /**
     * This function displays the graph in matrix form
     */
    void displayMap(){
        System.out.print("        ");
        for(int i=0;i<locationNames.size();i++){
            System.out.print(String.format("%6s", locationNames.get(i).substring(0,locationNames.get(i).length()<6?locationNames.get(i).length():6)));
            //System.out.print(locationNames.get(i));
            if(i!=locationNames.size()-1){
                System.out.print("  ");
            }
        }
        System.out.println();
        
        for(int i=0;i<distances.length;i++){
            System.out.print(String.format("%6s  ", locationNames.get(i).substring(0,locationNames.get(i).length()<6?locationNames.get(i).length():6)));
            for(int j=0;j<distances[i].length;j++){
                System.out.print(String.format("%6s", distances[i][j]));
                //System.out.print();
                if(j!=distances[i].length-1){
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}


/**
 * @parent will hold the reference of the parent Node for the current Node
 * @distanceFromSource will hold the distance of the current node from the source
 * @id will hold the location No as used as an index for the locationNames
 * @Children is a vector containing the references of all child Nodes of the current node
 */
class Node
{
    Node parent;
    int distanceFromSource;
    int id;
    String name;
    Vector<Node> Children=new Vector<Node>();
    
    Node(Node par,int distFromSrc,String name,int id){
        this.parent=par;
        this.distanceFromSource=distFromSrc;
        this.name=new String(name);
        this.id=id;
    }
    
    Node(){
        distanceFromSource=0;
    }

    public int getDistanceFromSource() {
        return distanceFromSource;
    }

    public void setDistanceFromSource(int distanceFromSource) {
        this.distanceFromSource = distanceFromSource;
    }
    
    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector<Node> getChildren() {
        return Children;
    }

    public void setChildren(Vector<Node> Children) {
        this.Children = Children;
    }
    
    public void addChild(Node n){
        Children.add(n);
    }
    
}
