package hugo.monton.blanco.eenavidad_retrofit.modelos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PersonajeDisney {
	private List<Object> videoGames;
	private List<Object> parkAttractions;
	private List<Object> films;
	private List<Object> shortFilms;
	private List<Object> tvShows;
	private String imageUrl;
	private String name;
	private List<Object> enemies;
	@SerializedName("_id")
	private int id;
	private List<Object> allies;
	private String url;

	public void setVideoGames(List<Object> videoGames){
		this.videoGames = videoGames;
	}

	public List<Object> getVideoGames(){
		return videoGames;
	}

	public void setParkAttractions(List<Object> parkAttractions){
		this.parkAttractions = parkAttractions;
	}

	public List<Object> getParkAttractions(){
		return parkAttractions;
	}

	public void setFilms(List<Object> films){
		this.films = films;
	}

	public List<Object> getFilms(){
		return films;
	}

	public void setShortFilms(List<Object> shortFilms){
		this.shortFilms = shortFilms;
	}

	public List<Object> getShortFilms(){
		return shortFilms;
	}

	public void setTvShows(List<Object> tvShows){
		this.tvShows = tvShows;
	}

	public List<Object> getTvShows(){
		return tvShows;
	}

	public void setImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
	}

	public String getImageUrl(){
		return imageUrl;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setEnemies(List<Object> enemies){
		this.enemies = enemies;
	}

	public List<Object> getEnemies(){
		return enemies;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setAllies(List<Object> allies){
		this.allies = allies;
	}

	public List<Object> getAllies(){
		return allies;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString() {
		String frase;

		frase = "ID: " + getId() + "\n";
		if (getFilms().size() > 0) {
			frase += "PELICULAS -> " + getFilms().size() + "\n";
			frase += "------------------------------------------------------------------------------------\n";
			for (int i = 0; i < getFilms().size(); i++) {
				frase += "Película " + (i + 1) + ": " + getFilms().get(i) + "\n";
			}
			frase += "------------------------------------------------------------------------------------\n";
		}
		if (getTvShows().size() > 0) {
			frase += "SERIES DE TV -> " + getTvShows().size() + "\n";
			frase += "------------------------------------------------------------------------------------\n";
			for (int i = 0; i < getTvShows().size(); i++) {
				frase += "Serie " + (i + 1) + ": " + getTvShows().get(i) + "\n";
			}
			frase += "------------------------------------------------------------------------------------\n";
		}
		if (getVideoGames().size() > 0) {
			frase += "VIDEOJUEGOS -> " + getVideoGames().size() + "\n";
			frase += "------------------------------------------------------------------------------------\n";
			for (int i = 0; i < getVideoGames().size(); i++) {
				frase += "Videojuego " + (i + 1) + ": " + getVideoGames().get(i) + "\n";
			}
			frase += "------------------------------------------------------------------------------------\n";
		}
		if (getParkAttractions().size() > 0) {
			frase += "PARQUES DE ATRACCIONES -> " + getParkAttractions().size() + "\n";
			frase += "------------------------------------------------------------------------------------\n";
			for (int i = 0; i < getParkAttractions().size(); i++) {
				frase += "Parque de atracción " + (i + 1) + ": " + getParkAttractions().get(i) + "\n";
			}
			frase += "------------------------------------------------------------------------------------\n";
		}
		if (getShortFilms().size() > 0) {
			frase += "CORTOMETRAJES -> " + getShortFilms().size() + "\n";
			frase += "------------------------------------------------------------------------------------\n";
			for (int i = 0; i < getShortFilms().size(); i++) {
				frase += "Cortometraje " + (i + 1) + ": " + getShortFilms().get(i) + "\n";
			}
			frase += "------------------------------------------------------------------------------------\n";
		}
		if (getEnemies().size() > 0) {
			frase += "ENEMIGOS -> " + getEnemies().size() + "\n";
			frase += "------------------------------------------------------------------------------------\n";
			for (int i = 0; i < getEnemies().size(); i++) {
				frase += "Enemigo " + (i + 1) + ": " + getEnemies().get(i) + "\n";
			}
			frase += "------------------------------------------------------------------------------------\n";
		}
		if (getAllies().size() > 0){
			frase += "ALIADOS -> " + getAllies().size() + "\n ";
			frase += "------------------------------------------------------------------------------------\n";
			for (int i = 0; i < getAllies().size(); i++) {
				frase += "Aliado " + (i+1) + ": " + getAllies().get(i) + "\n";
			}
			frase += "------------------------------------------------------------------------------------\n";
		}

		return frase;
	}
}