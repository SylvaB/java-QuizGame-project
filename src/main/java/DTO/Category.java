package DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
public class Category {
        @JsonProperty("canon")
        private boolean isCanon;
        @JsonProperty("title")
        private String title;
        @JsonProperty("id")
        private int id;

        public boolean getIsCanon() {
            return isCanon;
        }

        public void setIsCanon(boolean isCanon) {
            this.isCanon = isCanon;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
