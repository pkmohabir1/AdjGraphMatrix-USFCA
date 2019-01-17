public class GraphAdjMatrix implements Graph{
  public int[][] edgesV;
  public int v;

  public GraphAdjMatrix(int v){
    this.v=v;
    edgesV=new int[v][v];
    for(int i = 0; i <edgesV.length; i++){
      for(int j = 0; j<edgesV[i].length; j++){
        edgesV[i][j] = -1;
      }
    }
  }
//_____________________________________________________________________________
  public void addEdge(int v1, int v2, int w){
    edgesV[v1][v2] = w;
    edgesV[v2][v2] = w;
    }

//_____________________________________________________________________________
  public int getEdge(int v1, int v2){
    return edgesV[v1][v2];
  }
	
	
  private void remove(int v1, int v2){
  	edgesV[v1][v2] = -1;
    edgesV[v2][v2] = -1;
	}
  	

//_____________________________________________________________________________
  public int createSpanningTree(){
    boolean[] source = new boolean[v];
    int[] path = new int[v];
    int[] distance = new int[v];

    for(int k = 0; k<v; k++){
      source[k] = false;
      path[k] = -1;
      distance[k] = -1;
    }
    
    addEdge(0,0,0);
    int min = 0;
    for(int i = min; i<min+1; i++){
    
    	for(int j = 0; j<v;j++){
    			
			if(edgesV[i][j]!=-1){
				if(distance[j] == -1){
					distance[j] = edgesV[i][j];
    				path[j] = i; 
    			}
    			else if(distance[j]>edgesV[i][j]){
    				remove(path[j],j);
    				distance[j] = edgesV[i][j]; 
    				path[j] = i;
    			} 
    		}
    	}
    	source[i] = true; 
    	min = findMIN(source,distance); 
    }


  return sum(distance);
}

//_____________________________________________________________________________
  public int findMIN(boolean[] s, int[] d){
    int min = Integer.MAX_VALUE;

    for(int i = 0; i<v; i++){
      if(s[i] == false && d[i]<min && d[i]!= -1){
        min = i;
      }
    }
    return min;
  }
//_____________________________________________________________________________
private int sum(int[] distance){
  int num_sum = 0;
  for(int i = 0; i<distance.length; i++){
    num_sum = num_sum + distance[i];
  }
  return num_sum;
}
}