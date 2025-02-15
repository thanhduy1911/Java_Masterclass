package dev.duyhvt.section_8.Polymorphism;

public class NextMain {
    public static void main(String[] args) {
        Movie movie = Movie.getMovie("A", "Jaws");
        movie.watchMovie();

        Adventure jaws = (Adventure) Adventure.getMovie("A", "Jaws");
        jaws.watchMovie();

        Object comedy = Movie.getMovie("C", "Airplane");
        Comedy comedyMovie = (Comedy) comedy;
        comedyMovie.watchComedy();

        var airplane = Movie.getMovie("C", "Airplane");
        airplane.watchMovie();

        var plane = new Comedy("Airplane");
        plane.watchComedy();

        Object unknowObject = Movie.getMovie("S", "Star Wars");
        if (unknowObject.getClass().getSimpleName() == "Comedy") {
            Comedy c = (Comedy) unknowObject;
            c.watchComedy();
        } else if (unknowObject instanceof Adventure) {
            ((Adventure) unknowObject).watchAdventure();
        } else if (unknowObject instanceof ScienceFiction syfy) {
            syfy.watchScienceFiction();
        }
    }
}
