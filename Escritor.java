import java.util.ArrayList;

public class Escritor extends Persona implements Runnable {
    private static Integer nEscritores = 0;
    private Integer id;

    public  Escritor(ArrayList<Libro> book){
        super(book);
        this.id = ++nEscritores;
    }

    public void run(){
        while (!this.book.isEmpty()){
            try{
                Libro libro = getBook();
                this.book.remove(libro);
                libro.write();
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public String toString(){
        return "Escritor " + this.id;
    }
}
