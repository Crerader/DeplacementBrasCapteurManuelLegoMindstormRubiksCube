import lejos.hardware.Button;
import lejos.hardware.motor.Motor;
import lejos.hardware.motor.NXTRegulatedMotor;

public class Main {
	

	public static final int ANGLE_RETOUR = 450;

	/**
	 * Placer le capteur au dessus de la première face, le capteur revient en position -ANGLE_RETOUR.
	 * Button Enter,Escape : valider la position du capteur
	 * Button Up : deplacer vers l'avant le capteur
	 * Button Down : deplacer vers l'arriere le capteur
	 * Button Right : augmenter le pas 
	 * Button Left : diminuer le pas
	 * @param args
	 */
	public static void main(String[] args) {
		boolean stop = false;
		NXTRegulatedMotor motorCol = Motor.B;
		int pas = 20;
		while(!stop) {
			switch(Button.waitForAnyEvent()) {
				case Button.ID_ENTER:
				case Button.ID_ESCAPE:
					stop = true;
					break;
				case Button.ID_UP:
					motorCol.rotate(-pas);
					break;
				case Button.ID_DOWN:
					motorCol.rotate(pas);
					break;
				case Button.ID_RIGHT:
					pas += 10;
					System.out.println("Pas : " + pas);
					break;
				case Button.ID_LEFT:
					pas -= 10;
					System.out.println("Pas : " + pas);
					break;
			}
		}
		motorCol.rotate(Main.ANGLE_RETOUR);

	}

}
