/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A.Graph;

import java.io.BufferedReader;
import java.io.File; // lớp đọc file
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;// đối tượng lặp của TreeSet
import java.util.StringTokenizer;
import java.util.TreeSet;
/**
 *
 * @author ACER
 */
public class Graph extends TreeSet<Vertex> {
    public Graph(){
        super();
    } // thêm đỉnh vào đồ thị
    
    public void addVertex(Vertex v){
        this.add(v);
    } 
    // truy xuất đỉnh với tên đỉnh đã biết    
    Vertex get(String vertexName){
        Iterator it = this.iterator();
        while(it.hasNext()){
            Vertex v = (Vertex)(it.next());
            if (v.name.equals(vertexName)){
                return v;
            }
        }
        return null;
    } 

    // thêm một cạnh với 2 tên đỉnh đã biết    
    public boolean addEdge (String nameFrom, String nameTo){
        Vertex u = this.get(nameFrom); // tìm 2 tham khảo trên 2 đỉnh 
        Vertex v = this.get(nameTo);
        if (u==null || v==null) return false;
        Edge e = new Edge (u,v,1); //mặc đỉnh trọng số là 1
        u.adjList.add(e);
        return true;
    } 
    
    // thêm một cạnh với 2 tham khảo đỉnh đã biết 
    public boolean addEdge (Vertex u, Vertex v){
        if (u==null || v== null){
            return false; 
        }
        Edge e = new Edge (u,v,1);
      u.adjList.add(e);
      return true;
    }
    
    //các hành vi thêm cạnh có trọng số 
    public boolean addEdge (String nameFrom, String nameTo, double w){
        Vertex u = this.get(nameFrom);
        Vertex v = this.get(nameTo);
        if (u==null || v==null){
            return false;
        }
        Edge e = new Edge (u,v,w);
        u.adjList.add(e);
        return true;
    }
    
    public boolean addEdge (Vertex u, Vertex v, double w){
        if (u==null || v==null){
            return false;
        }
        Edge e = new Edge (u,v,w);
        u.adjList.add(e);
        return true;
    }
    
    public Graph loadFromFile1(String fName){
        Graph g =null; 
        File f = new File (fName);
        if (!f.exists()){
            System.out.println("File not found!");
            System.exit(0);
            return g;
        }
        try{
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String line = null; 
            StringTokenizer stk = null; 
            //Lấy tên các đỉnh 
            line = bf.readLine();
            if (line != null){
                g = new Graph(); // tạo đồ thị 
                //cắt chuỗi để lấy tên các đỉnh dựa trên khoảng trống 
                stk = new StringTokenizer(line," ");
                while (stk.hasMoreTokens()){
                    String name = stk.nextToken();
                    Vertex v = new Vertex(name);
                    g.add(v);
                }
            }
            // lấy các danh sách kề 
            while ((line=bf.readLine())!=null){
                stk = new StringTokenizer(line," ");
                //lấy đỉnh nguồn 
                String nameFrom = stk.nextToken();
                Vertex u = g.get(nameFrom);
                // tạo dạnh sách kề cho đỉnh này 
                while (stk.hasMoreTokens()){
                    String nameTo = stk.nextToken();
                    Vertex v = g.get(nameTo);
                    g.addEdge(u,v);
                }
            }
            bf.close();
            fr.close(); // đóng file
        }
        catch (Exception e){
            g = null;
        }
        return g;
    }
    
    // xuất đồ thị
    public String toString(){
        String s = "Empty graph";
        if(this==null||this.size()==0) return s;
        s="Graph:\n";
        Iterator<Vertex> it_Vertex = this.iterator();
        while(it_Vertex.hasNext()){
            // lấy 1 đỉnh 
            Vertex u = it_Vertex.next();
            s += u.getName() + "\t";
            Iterator<Edge> it_Edges = u.getAdjList().iterator();
            while (it_Edges.hasNext()){
                Edge e = it_Edges.next();
                s+= e.toString() + "  ";
            }
            s+="\n";
        }
        return s;
    }
    
    // duyệt đỉnh u với thứ tự đang có order, tập cạnh kết quả edges 
    protected int DFS(Vertex u, int order, ArrayList<Edge> edges){
        int new0rder = order +1; 
        u.setNum(order);
        // lấy danh sách đỉnh kề 
        Iterator<Edge> it = u.getAdjList().iterator();
        while(it.hasNext()){
            Edge e = it.next();
            Vertex v = e.getV();
            if(v.num==0){
                edges.add(e);
                new0rder = DFS(v, new0rder, edges);
            }
        }
        return new0rder;
    }
    
    //Duyệt Depth-First Search 
    public ArrayList<Edge> depthFirstSearch(){
        ArrayList result = new ArrayList<Edge>();
        //đánh dấu chưa duyệt cho tập đỉnh 
        Object[] vertices = this.toArray();
        for (int i=0;i<vertices.length;i++){
            Vertex v = (Vertex)vertices[i];
            v.num=0;
        }
        //Duyệt DFS cho tập đỉnh 
        Integer order =1; 
        for (int i =0; i<vertices.length;i++){
            Vertex v = (Vertex)vertices[i];
            if(v.num==0){
                order = DFS(v,order, result);
            }
        }
        return result.size()>0 ? result : null;
    }
    
    // breadth first search 
    public ArrayList<Edge> breadthFirstSearch(){
        ArrayList result = new ArrayList<Edge>();
        MyQueue<Vertex> queue = new MyQueue<Vertex>();
        // đánh dấu chưa duyệt cho tập đỉnh 
        Object [] vertices = this.toArray();
        for(int i =0; i<vertices.length;i++){
            Vertex v = (Vertex)vertices[i];
            v.num=0;
        }
        //Duyệt BFS cho đồ thị 
        int order =1; 
        for (int i =0; i<vertices.length;i++){
            Vertex u = (Vertex)vertices[i];
            if(u.num==0){
                u.num=order++;
                queue.enqueue(u);
                while(!queue.isEmpty()){
                    u=queue.dequeue(); // duyệt các đỉnh kề của u 
                    Iterator<Edge> it = u.adjList.iterator();
                    while(it.hasNext()){
                        Edge e = it.next();
                        Vertex v = e.getV(); // lấy đỉnh kề
                        if(v.num==0){
                            v.num=order++;
                            queue.enqueue(v);
                            result.add(e);
                        }
                    }
                }
            }
        }
        return result.size()>0 ? result : null;
    }
        
    //xuất tập cạnh ra PrintWriter
    public void printEdge(ArrayList<Edge> edges, PrintStream pw){
        if (edges == null || edges.isEmpty()){
            pw.println("No edge.");
        } else {
            pw.println("Set of edges: ");
            pw.println(edges);
        }
    }
}
