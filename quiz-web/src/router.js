import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import(/* webpackChunkName: "about" */ './views/About.vue')
    },
    // training module
    {
      path: '/training/start',
      component: () => import('./views/training/TrainingStart.vue')
    },
    {
      path: '/training/body',
      component: () => import('./views/training/TrainingBody.vue')
    },
    {
      path: '/training/finished',
      component: () => import('./views/training/TrainingFinished.vue')
    },
    {
      path: '/training/result',
      component: () => import('./views/training/TrainingResult.vue')
    },
    // login module need login or not all is ok
    {
      path: '/login',
      component: () => import('./views/Login.vue')
    },
    // user info module
    // person
    {
      path: '/person',
      component: () => import('./views/Person.vue')
    },
    // bonus module
    {
      path: '/bonus/choose',
      component: () => import('./views/Bonus.vue')
    },
    {
      path: '/setting',
      component: () => import('./views/setting/Setting.vue')
    },
    {
      path: '/setting/account',
      component: () => import('./views/setting/Account.vue')
    },
    {
      path: '/testadd',
      component: () => import('./plugins/Test.vue')
    }
  ]
})
