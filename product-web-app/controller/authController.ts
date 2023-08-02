import { Application, Request, Response } from 'express';
import Employee from '../model/register.js';
import { register } from '../service/authService.js';

export default function authController(app: Application) {
  //   app.get('/login', async (req: Request, res: Response) => {
  //     res.render('auth/login');
  //   });

  //   app.post('/login', async (req: Request, res: Response) => {
  //     let data: Login = req.body;

  //     try {
  //       req.session.token = await authService.login(data);
  //       res.redirect('/');
  //     } catch (error) {
  //       console.error(error);
  //       res.locals.errormessage = error.message;
  //       res.render('auth/login', req.body);
  //     }
  //   });

  app.get('/auth/register', async (req: Request, res: Response) => {
    res.render('auth/register');
  });

  app.post('/auth/register', async (req: Request, res: Response) => {
    const data: Employee = req.body;
    data.email += '@kainos.com';
    console.log(data);

    try {
      await register(data);
      res.redirect('auth/login');
    } catch (error) {
      res.locals.errormessage = error instanceof Error ? error.message : String(error);
      res.render('auth/register', req.body);
    }
  });
}
