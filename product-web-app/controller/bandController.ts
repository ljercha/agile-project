import {addBand} from '../service/bandService.js';
import { Application, Request, Response } from "express";
import { Band } from "../model/band.js";

export default function (app: Application){

    app.get('/admin/add-band', async (req: Request, res: Response) =>{
        res.render("add-band");
    });

    app.post('/admin/add-band', async(req: Request, res: Response) =>{
        let data: Band = req.body;

        try {
            const response = await addBand(data);            
        } catch (e) {
            console.error(e);
        };
        res.render("add-band")
    });
}