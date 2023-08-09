import * as url from 'url';
import path from 'path';
import express, { Application } from 'express';
import 'dotenv/config';
import session from 'express-session';
import nunjucks from 'nunjucks';
import axios from 'axios';
import JobSpecificationController from './controller/JobSpecificationController.js';

const dirname = url.fileURLToPath(new URL('.', import.meta.url));

axios.defaults.baseURL = process.env.API_URL;



const appViews = path.join(dirname, '/views/');

const nunjucksConfig = {
  autoescape: true,
  noCache: true,
  express: app,
};

nunjucks.configure(appViews, nunjucksConfig);

app.set('view engine', 'html');

app.use('/public', express.static(path.join(dirname, '/public')));

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

app.use(session({ secret: 'NOT_HARDCODED_SECRET', cookie: { maxAge: 60000 } }));

declare module 'express-session' {
  interface SessionData {
    token: string;
  }
}
app.set('view engine', 'html');
app.use('/public', express.static(path.join(dirname, 'public')));
new JobSpecificationController().init(app);


app.listen(3000, () => {
  // eslint-disable-next-line no-console
  console.log('Server listening on port 3000');
});
