import express, { Application, Request, Response} from "express";
import { Product } from "./model/product.js";


import 'dotenv/config';
import session from "express-session";
import path from "path";
import nunjucks from 'nunjucks';

import * as url from 'url';
import { productController } from "./controller/productController.js";

const __filename = url.fileURLToPath(import.meta.url);
const dirname = url.fileURLToPath(new URL('.', import.meta.url));


const app: Application = express();


const appViews = path.join(dirname, '/views');

const nunjucksConfig = {
    autoescape: true,
    noCache: true,
    express: app
}

nunjucks.configure(appViews, nunjucksConfig);

app.use(express.json());
app.use(express.urlencoded({extended: true}));

app.use(session({secret: 'NOT_HARDCODED_SECRET', cookie: {maxAge: 60000}}));

declare module "express-session" {
    interface SessionData {
        product: Partial<Product>;
        token: string;
    }
}

app.set('view engine', 'html');
app.use('/public', express.static(path.join(dirname, 'public')));

app.listen(3000, () => {
    console.log('Server listening on port 3000');
});

// Routing

app.get('/', (eq: Request, res: Response) => {
    res.redirect('/products');
});

productController(app);