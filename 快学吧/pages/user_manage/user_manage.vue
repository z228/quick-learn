<template>
	<el-card>
		<el-input v-model="input" placeholder="请输入内容"></el-input>
		<el-table :data="tableData" style="width: 100%">
<!-- 			<el-table-column prop="image" label="头像">
				<template slot-scope="scope">
					<img :src="scope.row.image" min-width="70" height="70" />
				</template>
			</el-table-column> -->
			<el-table-column prop="username" label="用户名" width="180">
			</el-table-column>
			<el-table-column prop="password" label="密码" width="180">
			</el-table-column>
			<el-table-column prop="nickname" label="昵称">
			</el-table-column>
			<el-table-column prop="sex" label="性别">
			</el-table-column>
			<el-table-column prop="phone" label="手机号">
			</el-table-column>
			<el-table-column prop="email" label="邮箱">
			</el-table-column>
		</el-table>
	</el-card>
</template>
<script>
	export default {
		data() {
			return {
				input: '',
				tableData: []
			}
		},
		methods: {
			saveImg(arr) {
				let fs = require('fs'); //引入文件读取模块
				let request = require('request');
				let a = document.createElement('a')
				arr.forEach((url, idx) => {
					let filename = url.split('/').pop()
					a.href = url
					a.download = `../../static/images/${filename}`
					a.click()
				})
			},
		},
		async onLoad() {
			let request = require('request')
			let arr = [];
			var username = uni.getStorageSync("username");
			var token = uni.getStorageSync("token");
			if (username == "" || token == "") {
				uni.navigateTo({
					url: "../login/login"
				})
			}
			await this.$request.get("/user/getAllUser", {}).then(res => {
				this.tableData = res.data;
				console.log(res.data);
			});
			for (let i = 0, len = this.tableData.length; i < len; i++) {
				let url = this.tableData[i].image;
				arr.push(url)
				this.tableData[i].image = url.split('/').pop()
			}
			// this.saveImg(arr)
			console.log(arr)
			console.log(this.tableData)
		}
	}
</script>