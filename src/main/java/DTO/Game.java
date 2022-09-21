package DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
public class Game {
        @JsonProperty("canon")
        private boolean isCanon;
        @JsonProperty("aired")
        private String aired;

        public boolean getIsCanon() {
            return isCanon;
        }

        public void setIsCanon(boolean isCanon) {
            this.isCanon = isCanon;
        }

        public String getAired() {
            return aired;
        }

        public void setAired(String aired) {
            this.aired = aired;
        }
    }
