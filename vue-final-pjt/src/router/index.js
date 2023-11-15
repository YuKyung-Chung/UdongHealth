import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import SearchView from '../views/SearchView.vue'
import KindView from '../views/KindView.vue'
import KindAll from '@/components/kind/KindAll.vue'
import KindUpperBody from '@/components/kind/KindUpperBody.vue'
import KindLowerBody from '@/components/kind/KindLowerBody.vue'
import KindCore from '@/components/kind/KindCore.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },
    { 
      path: '/search',
      name: 'search',
      component: SearchView

    },
    {
      path: '/kind',
      name: 'kind',
      component: KindView,
      children: [{
        path: '',
        component : KindAll
      },
      {
        path: 'upperBody',
        component: KindUpperBody

      }, {
        path: 'lowerBody',
        component: KindLowerBody
      }, {
        path: 'core',
        component: KindCore
      }],
      

    }
  ]
})

export default router
