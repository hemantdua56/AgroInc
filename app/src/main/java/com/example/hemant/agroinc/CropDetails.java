package com.example.hemant.agroinc;

/**
 * Created by hemant on 20-Mar-18.
 */

public class CropDetails {


        private String name;

        private int thumbnail;

        public CropDetails() {
        }

        public CropDetails(String name, int thumbnail) {
            this.name = name;

            this.thumbnail = thumbnail;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }



        public int getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(int thumbnail) {
            this.thumbnail = thumbnail;
        }
    }

