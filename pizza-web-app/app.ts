import { Application, Request, Response} from "express";
import { Product } from "./model/product";

const express = require('express');
const path = require('path');
const nunjucks = require('nunjucks');
const session = require('express-session');
const app: Application = express();

const appViews = path.join(__dirname, '/views');

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
app.use('/public', express.static(path.join(__dirname, 'public')));

app.listen(3000, () => {
    console.log('Server listening on port 3000');
});

// Routing

app.get('/', (eq: Request, res: Response) => {
    res.render('pizza', {
        title: 'New Pizza Time',
    });
});

require('./controller/authController')(app);

const authMiddleware = require('./middleware/auth');
app.use(authMiddleware);

require('./controller/productController')(app);
require('./controller/orderController')(app);