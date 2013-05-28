package pt.ulht.es.cookbook.domain;

import java.text.SimpleDateFormat;
import java.util.Comparator;

import org.joda.time.DateTime;


public class RecipeVersion extends RecipeVersion_Base {
    
    public  RecipeVersion(String titulo, String problema, String solucao, String autor, String tags) {
    	setTitulo(titulo);
    	setProblema(problema);
    	setSolucao(solucao);
    	setAutor(autor);
    	setTags(tags);
    	setCreationTimestamp(new DateTime());
    }

	public String getCreationTimestampFormatada() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return sdf.format( this.getCreationTimestamp().toDate() );
	}

	public void delete() {
		setRecipe(null);
		super.deleteDomainObject();
	}

	public static class CreationDateComparator implements Comparator<RecipeVersion> {

		public int compare(RecipeVersion r1, RecipeVersion r2) {
			return r1.getTitulo().compareToIgnoreCase(r2.getTitulo());
		}

	}

}
