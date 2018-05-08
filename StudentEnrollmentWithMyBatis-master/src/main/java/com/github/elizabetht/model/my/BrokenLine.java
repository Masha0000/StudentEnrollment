package com.github.elizabetht.model.my;

public class BrokenLine {


        private Point[]arrayCoordLine;

        public BrokenLine(Point[] arrayCoord) {
            this.arrayCoordLine = arrayCoord;
        }

        public BrokenLine(double [][] arrayCoord) {
        for (int i =0;i<arrayCoord.length;i++)
            this.arrayCoordLine[i]=new Point (arrayCoord[i][0],arrayCoord[i][1]);
        }
        public Point[] getArrayCoord() {
            return arrayCoordLine;
        }

        public void setArrayCoord(Point[] arrayCoord) {
            this.arrayCoordLine = arrayCoord;
        }

}
