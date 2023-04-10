import { createProdMockServer } from 'vite-plugin-mock/es/createProdMockServer';
// 加载所有的ts文件作为组件
const Modules = import.meta.glob('./mock/*.ts');

export function setupProdMockServer() {
	// 创建mock接口
  createProdMockServer([
    ...Modules
  ]);
}
