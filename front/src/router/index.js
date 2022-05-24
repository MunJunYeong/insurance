/* eslint-disable */
import Vue from 'vue'
import VueRouter from 'vue-router'

import core from '../views/core/layout/CoreLayout.vue'
import home from '../views/core/MainHome.vue'


import auth from '../views/auth/layout/AuthLayout.vue'
import signIn from '../views/auth/SignIn.vue'
import signUp from '../views/auth/SignUp.vue'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/home', // 초기 진입 페이지 설정
  },
  {
    path: '/auth',
    component: auth,
    children : [
      {
        path : 'signIn',
        component : signIn,
      },
      {
        path : 'signUp',
        component : signUp,
      }
    ]
  },
  {
    path: '/',
    component: core,
    children : [
      {
        path : 'home',
        component : home,
      },
    ]
  },

]

const router = new VueRouter({
  routes
})

export default router
