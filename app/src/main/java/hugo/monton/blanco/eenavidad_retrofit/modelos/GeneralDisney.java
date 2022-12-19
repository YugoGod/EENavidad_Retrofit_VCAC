package hugo.monton.blanco.eenavidad_retrofit.modelos;

import java.util.List;

public class GeneralDisney{
	private List<PersonajeDisney> data;
	private String nextPage;
	private int count;
	private int totalPages;

	public void setData(List<PersonajeDisney> data){
		this.data = data;
	}

	public List<PersonajeDisney> getData(){
		return data;
	}

	public void setNextPage(String nextPage){
		this.nextPage = nextPage;
	}

	public String getNextPage(){
		return nextPage;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setTotalPages(int totalPages){
		this.totalPages = totalPages;
	}

	public int getTotalPages(){
		return totalPages;
	}

	@Override
 	public String toString(){
		return 
			"GeneralDisney{" + 
			"data = '" + data + '\'' + 
			",nextPage = '" + nextPage + '\'' + 
			",count = '" + count + '\'' + 
			",totalPages = '" + totalPages + '\'' + 
			"}";
		}
}