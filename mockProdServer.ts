import { createProdMockServer } from 'vite-plugin-mock/es/createProdMockServer';
import userModule from './mock/user'
import tableModule from './mock/table'
import cardModule from './mock/card'
import workModule from './mock/work'
import UserMoudle from './mock/systemUser'
import MenuMoudle from './mock/systemManagers'

export function setupProdMockServer() {
  createProdMockServer([
    ...userModule,
    ...tableModule,
    ...cardModule,
    ...workModule,
    ...UserMoudle,
	...MenuMoudle
  ]);
}
