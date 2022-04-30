<template>
    <el-container>
        <el-header>油田地震处理解释任务的资源管理系统</el-header>
        <el-container>
            <el-aside width="300px">
                <h5 class="title">导航栏</h5>
                <el-menu class="el-menu-vertical-demo"
                         @open="handleOpen"
                         @close="handleClose"
                         @select="itemSelected"
                         style="text-align: left;border-right: none;"
                         active-text-color="#ea6026"
                         background-color="#000a40"
                         text-color="#ffffff"
                         default-active="/"
                         :unique-opened="true"
                         router>
                    <el-menu-item  index="/">
                        <i class="el-icon-s-home icon_color"></i>
                        <span slot="title">首页</span>
                    </el-menu-item>
                    <el-submenu index="101">
                        <template slot="title">
                            <i class="el-icon-s-help icon_color"></i>
                            <span>资源监控</span>
                        </template>
                        <el-menu-item style="font-size: 16px" index="/deviceState">节点状态信息</el-menu-item>
                        <el-menu-item style="font-size: 16px" index="/memUse">存储使用情况</el-menu-item>
                        <el-menu-item style="font-size: 16px" index="/softwareLicense">软件许可信息</el-menu-item>
                        <el-menu-item style="font-size: 16px" index="/searchZabbixAgent">故障Agent查询</el-menu-item>
                    </el-submenu>
                    <el-submenu index="102">
                        <template slot="title">
                            <i class="el-icon-s-platform icon_color"></i>
                            <span>资源分析与管理</span>
                        </template>
                        <el-menu-item style="font-size: 16px" index="/nodeDeploy">任务下达</el-menu-item>
                        <el-submenu index="102-1">
                            <template slot="title"><span>软件/节点报表</span></template>
                            <el-menu-item style="font-size: 16px" index="/showNodeTypeTable">节点效率查询</el-menu-item>
                            <el-menu-item style="font-size: 16px" index="/showSoftNameTable">单节点利用效率</el-menu-item>
                        </el-submenu>
                        <el-submenu index="102-2" >
                            <template slot="title" >
                                <span slot="title">软件许可分析</span>
                            </template>
                            <el-submenu index="102-2-2" >
                                <template slot="title" ><span>全部软件</span></template>
                                <el-menu-item style="font-size: 16px" index="/useFrequencyAll">软件使用频率</el-menu-item>
                                <el-menu-item style="font-size: 16px" index="/useTimeAll">软件使用时间</el-menu-item>
                            </el-submenu>
                            <el-submenu index="102-2-3" style="background: none">
                                <template slot="title"><span>单一软件</span></template>
                                <el-menu-item style="font-size: 16px" index="/useFrequencyOne">模块使用频率</el-menu-item>
                                <el-menu-item style="font-size: 16px" index="/useTimeOne">模块使用时间</el-menu-item>
                            </el-submenu>
                        </el-submenu>
                        <el-submenu index="102-3" style="background: none">
                            <template slot="title"><span>软件/用户报表</span></template>
                            <el-menu-item style="font-size: 16px" index="/softOfUser">软件用户数据</el-menu-item>
                            <el-menu-item style="font-size: 16px" index="/userUseTime">用户软件使用时间</el-menu-item>
                        </el-submenu>
                    </el-submenu>
                    <el-submenu index="103">
                        <template slot="title">
                            <i class="el-icon-menu icon_color"></i>
                            <span>系统管理模块</span>
                        </template>
                        <el-menu-item style="font-size: 16px" index="">操作日志</el-menu-item>
                        <el-submenu index="103-1">
                            <template slot="title"><span>权限管理</span></template>
                            <el-menu-item style="font-size: 16px" index="">服务及功能组件维护</el-menu-item>
                            <el-menu-item style="font-size: 16px" index="">角色授权及维护</el-menu-item>
                            <el-menu-item style="font-size: 16px" index="">用户授权及维护</el-menu-item>
                        </el-submenu>
                        <el-menu-item style="font-size: 16px" index="">密码修改</el-menu-item>
                    </el-submenu>

                </el-menu>
            </el-aside>
            <el-main>
                <router-view></router-view>
            </el-main>
        </el-container>
        <div v-if="isItemSelected" class="bg_welcome center">
            <el-row>
                <el-col class="text_big text_light_blue place_bottom text_space">推开信息的一扇窗</el-col>
            </el-row>
            <h3 class="text_dark text_light_blue">简单一点，让一切以视觉呈现</h3>
        </div>
        <span class="bg_icon center"></span>
    </el-container>
</template>

<script>
export default {
    name: "home",
    data() {
        return {
            isItemSelected: false,//选项是否选中,控制欢迎界面是否显示
        }
    },
    created() {
        if (this.$route.params.isVisible) {//接受isVisible,控制背景icon显示
            this.isItemSelected = true
        }
    },
    methods: {
        handleOpen(key, keyPath) {
            console.log(key, keyPath);
        },
        handleClose(key, keyPath) {
            console.log(key, keyPath);
        },
        itemSelected(index, indexPath) {
            console.log(index, indexPath)
            this.isItemSelected = false
        }
    }
};
</script>

<style scoped>
.el-container, .el-main {
    background: #000a40;
}

.el-header {
    background: url("../assets/bg_header.png");
    background-size: 100% 100%;
    font-size: 16px;
    font-weight: bold;
    color: #caf6f6;
    text-align: center;
    letter-spacing: 10px;
    line-height: 60px;
    margin-top: 16px;
}

.el-aside {
    background: url("../assets/bg_aside.png");
    background-size: 100% 100%;
    color: #ffffff;
    text-align: center;
    padding: 40px 40px 150px;
}

.el-main {
    color: #ffffff;
    text-align: center;
    padding: 0;
    height: 95vh;
}

.title {
    color: #ffffff;
    font-size: 16px;
}

body > .el-container {
    margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
    line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
    line-height: 316px;
}

.icon_color {
    color: #16daec;
}

.center {
    position: absolute;
    margin: auto;
    left: 0;
    right: 0;
    top: 0;
    bottom: 0;
}
span{
    font-size:16px;
}
.bg_icon {
    width: 100vh;
    height: 57vh;
    background: url("../assets/bg_earth4.png");
    background-size: 100% 100%;
    opacity: 0.9;
    z-index: 0;
}

.bg_welcome {
    width: 100vh;
    height: 57vh;
    background: url("../assets/bg_earth5.png");
    background-size: 100% 100%;
    opacity: 0.9;
    z-index: 0;
}

.text_big {
    font-size: 40px;
    font-weight: lighter;
    opacity: 0.8;
}

.text_small {
    font-size: 14px;
}

.text_light_blue {
    color: #17b3f0;
}

.text_dark {
    opacity: 0.5;
    font-weight: lighter;
}

.text_space {
    letter-spacing: 10px;
}

.place_bottom {
    margin-top: 55vh;
}
</style>