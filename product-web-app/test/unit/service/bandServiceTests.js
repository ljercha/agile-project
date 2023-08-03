var axios = require("axios");

var MockAdapter = require("axios-mock-adapter");

var chai = require("chai");

const { expect, assert } = chai;

const bandService = require("../../../app/service/bandService");


const band = {

    name: "Kamil",
  
    level: "Mocha",
  
    responsibilities: "Chai",
  
  };

describe("bandService", function () {
    describe("addBand", function () {
        it("should return error 500 when could not create employee", async () => {

            var mock = new MockAdapter(axios);
      
            mock.onPost(bandService.URL, band).reply(500);
      
       
      
            try {
      
              await bandService.addBand(band);
      
            } catch (e) {
      
              expect(e.message).to.equal("Could not create band");
      
            }
      
          });

        it("should return error 400 when pass invalid data", async () => {

        var mock = new MockAdapter(axios);
    
        mock.onPost(bandService.URL, band).reply(400);
    
    

        try {
    
            await bandService.addBand(band);
    
        } catch (e) {
    
            expect(e.message).to.equal("Invalid data");
    
        }
    
        });
    })});