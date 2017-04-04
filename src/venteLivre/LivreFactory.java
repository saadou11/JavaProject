package venteLivre;

public class LivreFactory extends AbstractFactory {

	@Override
	public Livre getLivre(String livreInstence) {
		
		if(livreInstence == null || livreInstence.equals("")){
		return null;
		
		}else if (livreInstence.equalsIgnoreCase("bd")){
			return new BD();
			
		}else if (livreInstence.equalsIgnoreCase("roman")){
			return new Roman();
			
		}else if (livreInstence.equalsIgnoreCase("magazine")){
			return new Magazine();
			
		}
		return null;
	}

}
