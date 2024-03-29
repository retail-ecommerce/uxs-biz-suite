import React from 'react'
import PropTypes from 'prop-types'
import {
  Layout,
  Menu,
  Icon,
  Avatar,
  Dropdown,
  Tag,
  message,
  Spin,
  Breadcrumb,
  AutoComplete,
  Input,Button
} from 'antd'
import DocumentTitle from 'react-document-title'
import { connect } from 'dva'
import { Link, Route, Redirect, Switch } from 'dva/router'
import moment from 'moment'
import groupBy from 'lodash/groupBy'
import { ContainerQuery } from 'react-container-query'
import classNames from 'classnames'
import styles from './LevelOneCategory.app.less'
import {sessionObject} from '../../utils/utils'

import HeaderSearch from '../../components/HeaderSearch';
import NoticeIcon from '../../components/NoticeIcon';
import GlobalFooter from '../../components/GlobalFooter';


import GlobalComponents from '../../custcomponents';

import PermissionSettingService from '../../permission/PermissionSetting.service'
import appLocaleName from '../../common/Locale.tool'

const  {  filterForMenuPermission } = PermissionSettingService

const isMenuItemForDisplay = (item, targetObject, targetComponent) => {
  return true
}

const filteredMenuItems = (targetObject, targetComponent) => {
    const menuData = sessionObject('menuData')
    const isMenuItemForDisplayFunc = targetComponent.props.isMenuItemForDisplayFunc||isMenuItemForDisplay
    return menuData.subItems.filter(item=>filterForMenuPermission(item,targetObject,targetComponent)).filter(item=>isMenuItemForDisplayFunc(item,targetObject,targetComponent))
}



const { Header, Sider, Content } = Layout
const { SubMenu } = Menu

const query = {
  'screen-xs': {
    maxWidth: 575,
  },
  'screen-sm': {
    minWidth: 576,
    maxWidth: 767,
  },
  'screen-md': {
    minWidth: 768,
    maxWidth: 991,
  },
  'screen-lg': {
    minWidth: 992,
    maxWidth: 1199,
  },
  'screen-xl': {
    minWidth: 1200,
  },
}




class LevelOneCategoryBizApp extends React.PureComponent {
  constructor(props) {
    super(props)
     this.state = {
      openKeys: this.getDefaultCollapsedSubMenus(props),
    }
  }

  componentDidMount() {}
  componentWillUnmount() {
    clearTimeout(this.resizeTimeout)
  }
  onCollapse = (collapsed) => {
    this.props.dispatch({
      type: 'global/changeLayoutCollapsed',
      payload: collapsed,
    })
  }

  getDefaultCollapsedSubMenus = (props) => {
    const currentMenuSelectedKeys = [...this.getCurrentMenuSelectedKeys(props)]
    currentMenuSelectedKeys.splice(-1, 1)
    if (currentMenuSelectedKeys.length === 0) {
      return ['/levelOneCategory/']
    }
    return currentMenuSelectedKeys
  }
  getCurrentMenuSelectedKeys = (props) => {
    const { location: { pathname } } = props || this.props
    const keys = pathname.split('/').slice(1)
    if (keys.length === 1 && keys[0] === '') {
      return [this.menus[0].key]
    }
    return keys
  }
  
  getNavMenuItems = (targetObject) => {
  

    const menuData = sessionObject('menuData')
    const targetApp = sessionObject('targetApp')
	const {objectId}=targetApp;
  	const userContext = null
    return (
      
		  <Menu
             theme="dark"
             mode="inline"
            
             
             onOpenChange={this.handleOpenChange}
            
             defaultOpenKeys={['firstOne']}
             style={{ margin: '16px 0', width: '100%' }}
           >
           

             <Menu.Item key="dashboard">
               <Link to={`/levelOneCategory/${this.props.levelOneCategory.id}/dashboard`}><Icon type="dashboard" /><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
             </Menu.Item>
             
		 <Menu.Item key="homepage">
               <Link to={"/home"}><Icon type="home" /><span>{appLocaleName(userContext,"Home")}</span></Link>
             </Menu.Item>
             
             
         {filteredMenuItems(targetObject,this).map((item)=>(<Menu.Item key={item.name}>
          <Link to={`/${menuData.menuFor}/${objectId}/list/${item.name}/${item.displayName}${appLocaleName(userContext,"List")}`}>
          <Icon type="bars" /><span>{item.displayName}</span>
          </Link>
        </Menu.Item>))}
       
       <Menu.Item key="preference">
               <Link to={`/levelOneCategory/${this.props.levelOneCategory.id}/preference`}><Icon type="setting" /><span>{appLocaleName(userContext,"Preference")}</span></Link>
             </Menu.Item>
      
           </Menu>
    )
  }
  



  getLevelTwoCategorySearch = () => {
    const {LevelTwoCategorySearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Level Two Category",
      role: "levelTwoCategory",
      data: state._levelOneCategory.levelTwoCategoryList,
      metaInfo: state._levelOneCategory.levelTwoCategoryListMetaInfo,
      count: state._levelOneCategory.levelTwoCategoryCount,
      currentPage: state._levelOneCategory.levelTwoCategoryCurrentPageNumber,
      searchFormParameters: state._levelOneCategory.levelTwoCategorySearchFormParameters,
      searchParameters: {...state._levelOneCategory.searchParameters},
      expandForm: state._levelOneCategory.expandForm,
      loading: state._levelOneCategory.loading,
      partialList: state._levelOneCategory.partialList,
      owner: { type: '_levelOneCategory', id: state._levelOneCategory.id, 
      referenceName: 'parentCategory', 
      listName: 'levelTwoCategoryList', ref:state._levelOneCategory, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(LevelTwoCategorySearch)
  }
  getLevelTwoCategoryCreateForm = () => {
   	const {LevelTwoCategoryCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "levelTwoCategory",
      data: state._levelOneCategory.levelTwoCategoryList,
      metaInfo: state._levelOneCategory.levelTwoCategoryListMetaInfo,
      count: state._levelOneCategory.levelTwoCategoryCount,
      currentPage: state._levelOneCategory.levelTwoCategoryCurrentPageNumber,
      searchFormParameters: state._levelOneCategory.levelTwoCategorySearchFormParameters,
      loading: state._levelOneCategory.loading,
      owner: { type: '_levelOneCategory', id: state._levelOneCategory.id, referenceName: 'parentCategory', listName: 'levelTwoCategoryList', ref:state._levelOneCategory, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(LevelTwoCategoryCreateForm)
  }
  
  getLevelTwoCategoryUpdateForm = () => {
    const userContext = null
  	const {LevelTwoCategoryUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._levelOneCategory.selectedRows,
      role: "levelTwoCategory",
      currentUpdateIndex: state._levelOneCategory.currentUpdateIndex,
      owner: { type: '_levelOneCategory', id: state._levelOneCategory.id, listName: 'levelTwoCategoryList', ref:state._levelOneCategory, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(LevelTwoCategoryUpdateForm)
  }


  
  buildRouters = () =>{
  	const {LevelOneCategoryDashboard} = GlobalComponents
  	const {LevelOneCategoryPreference} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/levelOneCategory/:id/dashboard", component: LevelOneCategoryDashboard},
  	{path:"/levelOneCategory/:id/preference", component: LevelOneCategoryPreference},
  	
  	
  	
  	{path:"/levelOneCategory/:id/list/levelTwoCategoryList", component: this.getLevelTwoCategorySearch()},
  	{path:"/levelOneCategory/:id/list/levelTwoCategoryCreateForm", component: this.getLevelTwoCategoryCreateForm()},
  	{path:"/levelOneCategory/:id/list/levelTwoCategoryUpdateForm", component: this.getLevelTwoCategoryUpdateForm()},
     	
  	
  	]
  	
  	const {extraRoutesFunc} = this.props;
	const extraRoutes = extraRoutesFunc?extraRoutesFunc():[]
    const finalRoutes = routers.concat(extraRoutes)
    
  	return (<Switch>
             {finalRoutes.map((item)=>(<Route key={item.path} path={item.path} component={item.component} />))}    
  	  	</Switch>)
  	
  
  }
 

  getPageTitle = () => {
    // const { location } = this.props
    // const { pathname } = location
    const title = 'User Experience Service'
    return title
  }
 
  handleOpenChange = (openKeys) => {
    const latestOpenKey = openKeys.find(key => this.state.openKeys.indexOf(key) === -1)
    this.setState({
      openKeys: latestOpenKey ? [latestOpenKey] : [],
    })
  }
   toggle = () => {
     const { collapsed } = this.props
     this.props.dispatch({
       type: 'global/changeLayoutCollapsed',
       payload: !collapsed,
     })
   }
    logout = () => {
   
    console.log("log out called")
    this.props.dispatch({ type: 'launcher/signOut' })
  }
   render() {
     // const { collapsed, fetchingNotices,loading } = this.props
     const { collapsed } = this.props
     const { breadcrumb }  = this.props
  
     const targetApp = sessionObject('targetApp')
     const currentBreadcrumb =sessionObject(targetApp.id)
     const userContext = null
     
     const menuProps = collapsed ? {} : {
       openKeys: this.state.openKeys,
     }
     const layout = (
     <Layout>
        <Header>
          
          <div className={styles.left}>
          <img
            src="./favicon.png"
            alt="logo"
            onClick={this.toggle}
            className={styles.logo}
          />
          {currentBreadcrumb.map((item)=>{
            return (<Link  key={item.link} to={`${item.link}`} className={styles.breadcrumbLink}> &gt;{item.name}</Link>)

          })}
         </div>
          <div className={styles.right}  >
          <Button type="primary"  icon="logout" onClick={()=>this.logout()}>
          {appLocaleName(userContext,"Exit")}</Button>
          </div>
          
        </Header>
       <Layout>
         <Sider
           trigger={null}
           collapsible
           collapsed={collapsed}
           breakpoint="md"
           onCollapse={()=>this.onCollapse(collapsed)}
           collapsedWidth={56}
           className={styles.sider}
         >

		 {this.getNavMenuItems(this.props.levelOneCategory)}
		 
         </Sider>
         <Layout>
           <Content style={{ margin: '24px 24px 0', height: '100%' }}>
           
           {this.buildRouters()}
 
             
             
           </Content>
          </Layout>
        </Layout>
      </Layout>
     )
     return (
       <DocumentTitle title={this.getPageTitle()}>
         <ContainerQuery query={query}>
           {params => <div className={classNames(params)}>{layout}</div>}
         </ContainerQuery>
       </DocumentTitle>
     )
   }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
  fetchingNotices: state.global.fetchingNotices,
  notices: state.global.notices,
  levelOneCategory: state._levelOneCategory,
  ...state,
}))(LevelOneCategoryBizApp)



