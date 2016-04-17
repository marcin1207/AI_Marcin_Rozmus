/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Samochod {

   private double x, y, a; // x,y and angle
   private int w, h; // width and height

   // constructor
   public Samochod(double x, double y, double a, int w, int h) {

      this.x = x;
      this.y = y;
      this.a = a;
      this.w = w;
      this.h = h;
   }

   // returning all the necessary value of this class

   public double getX() {
      return x;
   }

   public double getY() {
      return y;
   }

   public double getA() {
      return a;
   }

   public int getW() {
      return w;
   }

   public int getH() {
      return h;
   }

   // setting the angle
   public void setA(int aa) {

      a = Math.toRadians(aa);
   }

   // move toward the angle
   // //forward
   public void moveForward() {
      x += Math.cos(a)*1.5f;
      y += Math.sin(a)*1.5f;  }
   // //backward
   public void moveBackword() {
      x -= Math.cos(a)*1.5f;
      y -= Math.sin(a)*1.5f;
   }

}
