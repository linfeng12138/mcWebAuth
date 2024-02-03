linfeng.animat.floatText(['心之所向', '素履以往', '林风最帅'])

const $http = axios.create({
    baseURL: 'http://192.168.10.100:8080',
    timeout: 1000
});

window.onload = () => {
    new Vue({
        el: '#bigBox',
        data: {
            login: {
                username: '',
                password: '',
                display: 'none'
            },
            alertBox: {
                title: '请输入title',
                text: '请输入内容',
                display: 'none'
            },
            userInfoBox: {
                userInfo: {
                    air: 0,
                    food: 0,
                    gamemode: 0,
                    health: 0,
                    id: 0,
                    lv: 0,
                    maxAir: 0,
                    maxHealth: 0,
                    money: 0,
                    name: null,
                    uuid: null
                },
                display: 'none'
            },
            buyMaxHealthAlert: {
                title: '请输入title',
                text: '请输入内容',
                display: 'none'
            }
        },
        async mounted(){
            this.getUserInfo()
        },
        methods: {
            async getUserInfo(){
                const res = await $http.post(`/player/getInfo?uuid=${linfeng.cookie.get("token")}`)
                // console.log(res);
                if(res.data.data === null){
                    this.login.display = 'block'
                    this.userInfoBox.display = 'none'
                }else{
                    this.userInfoBox.userInfo = res.data.data
                    this.login.display = 'none'
                    this.userInfoBox.display = 'block'
                }
                // console.log(this.userInfoBox.userInfo);
            },
            loginHelpInfo() {
                this.alertShow('登录提示', '用户名为你游戏中的名字。密码是需要在游戏中使用\"/webAuth setPwd 密码 确认密码\"来设置密码的，若没有设置密码则无法登录本网站。修改密码也是需要到游戏里使用\"/webAuth setPwd 密码 确认密码\"来设置密码无需输入旧密码')
            },
            alertShow(title, text) {
                this.alertBox = {
                    title,
                    text,
                    display: 'block'
                }
            },
            alertHide() {
                this.alertBox = {
                    title: '请输入title',
                    text: '请输入内容',
                    display: 'none'
                }
            },
            buyMaxHealthAlertShow(title, text){
                this.buyMaxHealthAlert = {
                    title,
                    text,
                    display: 'block'
                }
            },
            buyMaxHealthAlertHide(){
                this.buyMaxHealthAlert = {
                    title: '请输入title',
                    text: '请输入内容',
                    display: 'none'
                }
            },
            async buyHealthBtnFun(){
                alert("请先确保自己游戏账号不在线，由于技术原因目前只能做到玩家不在游戏内才可以购买，否则会购买失败金币也会扣除，后果自负。")
                const uuid = linfeng.cookie.get("token")
                const res = await $http.post(`/player/cat/maxHealth?uuid=${uuid}`);
                // console.log(res);
                if(res.data.code === 400 || res.data.data === null){
                    this.alertShow("未知错误", res.data.message)
                    return
                }
                this.buyMaxHealthAlertShow("购买最大生命值", `您当前最大生命值为${this.userInfoBox.userInfo.maxHealth}，本次购买两点生命值（一颗心）需要消费${res.data.data}金币，您当前的金币为：${this.userInfoBox.userInfo.money}，是否购买？（注意：最大生命值最多可购买到40。购买时游戏内账号不能在线，否则会购买失败，钱也会扣除，后果自负）`)
            },
            async buyMaxHealth(){
                const uuid = linfeng.cookie.get("token")
                const res = await $http.post(`/player/buy/maxHealth?uuid=${uuid}`);
                // console.log(res);
                this.buyMaxHealthAlertHide();
                if(res.data.code === 400){
                    this.alertShow("购买失败", res.data.message)
                    return 
                }
                this.alertShow("购买成功", `林风提示：(●'◡'●)感谢您的消费，欢迎怨种再来！`)
                this.getUserInfo();
            },
            async loginFun() {
                // console.log("aaa");
                const userInfo = {
                    username: this.login.username,
                    password: this.login.password
                }
                // console.log("userInfo:", userInfo);
                if(userInfo.username.trim() === '' || userInfo.password.trim() === ''){
                    this.alertShow('登录失败', '用户名或密码未填写')
                    return
                }
                const res = await $http.post("/user/auth/login", userInfo)
                // console.log(res);
                if(res.data.code != 200){
                    this.alertShow('登录失败', res.data.message)
                    this.login = {
                        username: '',
                        password: '',
                        display: 'block'
                    }
                }else{
                    this.login = {
                        username: '',
                        password: '',
                        display: 'none'
                    }
                    linfeng.cookie.set('token', res.data.data)
                    this.getUserInfo()
                }
            }
        }
    })
}
