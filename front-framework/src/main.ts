import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import { baidu } from './utils/system/statistics'
import 'element-plus/theme-chalk/display.css' // 引入基于断点的隐藏类
import 'element-plus/dist/index.css'
import 'normalize.css' // css初始化
import './assets/style/common.scss' // 公共css
import './theme/modules/chinese/index.scss'
import App from './App.vue'
import store from './store'
import router from './router'
import { getAuthRoutes } from './router/permission'
import i18n from './locale'


/** 
 * 权限路由处理主方法 
 * 	等待后端请求完成后加载页面
 */
getAuthRoutes().then(() => {
  const app = createApp(App)
  app.use(ElementPlus, { size: store.state.app.elementSize })
  app.use(store)
  app.use(router)
  app.use(i18n)
  // app.config.performance = true
  app.mount('#app')
})

