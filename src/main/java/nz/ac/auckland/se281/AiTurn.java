package nz.ac.auckland.se281;

/** Interface implements the AiTurn (EASYAi, MEDIUMAi OR HARDAi) to generate Ai fingers. */
public interface AiTurn {

  /** This method is used to generate the Ai fingers depending on the difficulty level of Ai. */
  public abstract int playFingers();
}
