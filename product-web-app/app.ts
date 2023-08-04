import express, { Application} from 'express';
import * as url from 'url';
import 'dotenv/config';
import session from 'express-session';
import path from 'path';
import nunjucks from 'nunjucks';


import authController from './controller/authController.js';
import { authMiddleware } from './middleware/auth.js';

const dirname = url.fileURLToPath(new URL('.', import.meta.url));

const app: Application = express();

const appViews = path.join(dirname, '/views');

const nunjucksConfig = {
  autoescape: true,
  noCache: true,
  express: app,
};

nunjucks.configure(appViews, nunjucksConfig);

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

app.use(session({ secret: 'NOT_HARDCODED_SECRET', cookie: { maxAge: 6000000 } }));

declare module 'express-session' {
  interface SessionData {
    token: string;
  }
}

app.set('view engine', 'html');
app.use('/public', express.static(path.join(dirname, 'public')));

app.listen(3000, () => {
  // eslint-disable-next-line no-console
  console.log('Server listening on port 3000');
});

app.get('/', async (req: Request, res: Response) => {
  if (!req.session.token || req.session.token.length === 0) {
    res.redirect('auth/login');
  } else {
    res.render('index', { title: 'Main page' });
  }
});

authController(app);

app.use(authMiddleware);
