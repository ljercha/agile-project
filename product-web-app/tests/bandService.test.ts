import axios from 'axios';
import MockAdapter from 'axios-mock-adapter';
import chai from 'chai';
import dotenv from 'dotenv';
import { addBand } from '../service/bandService.js';

const band = {

    name: "Kamil",
  
    level: "Mocha",
  
    responsibilities: "Chai",
  
  };

  const { expect } = chai;
  const BASE_URL = process.env.API_URL;

describe("bandService", function () {
    describe("addBand", function () {
        it("should return error 500 when could not create employee", async () => {

            var mock = new MockAdapter(axios);
      
            mock.onPost(`${BASE_URL}/admin/band`, band).reply(500);
            
      
            try {
      
              await addBand(band);
      
            } catch (error) {
              const errorMessage: string = error instanceof Error ? error.message : String(error);

              expect(errorMessage).to.equal("Could not create band");
      
            }
      
          });

        it("should return error 400 when pass invalid data", async () => {

        var mock = new MockAdapter(axios);
    
        mock.onPost(`${BASE_URL}/admin/band`, band).reply(400);
    
    

        try {
    
            await addBand(band);
    
        } catch (error) {
          const errorMessage: string = error instanceof Error ? error.message : String(error);

            expect(errorMessage).to.equal("Could not create band");
    
        }
    
        });
    })});