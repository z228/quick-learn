<template>
	<view>
		<view class="top_content">
			<image src="../../static/xuexi.png"></image>
		</view>
		<view class="main_content">
			<form @submit="formSubmit">
			    <view class="moudle">
					<view class="right_content">
						<view class="label_text" >账号</view>
						<input name="username" class="text" placeholder="Username"/>
					</view>
			    </view>
				<view class="moudle">
					<view class="right_content">
						<view class="label_text">密码</view>
						<input password="true" name="password" class="text" placeholder="Password"/>
					</view>
				</view>
				<view class="btn">
					<button form-type="submit">登录</button>
				</view>
			</form>		
		</view>
		<view class="foot_content">
			<view><navigator url="../register/register">注册</navigator></view>
			<view><span>|</span></view>
			<view><navigator>找回密码</navigator></view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			formSubmit: function(e) {
				this.$request.get("/user/login",{
					"username":JSON.stringify(e.detail.value.username),
					"password":JSON.stringify(e.detail.value.password)
				}).then(res=>{
					if(res.data.code!==200){
						uni.showModal({
							content: '您输入的账号或密码错误，请重新输入',
							showCancel: false
						});
					}else{
						uni.setStorageSync("username",JSON.stringify(e.detail.value.username));
						uni.setStorageSync("token",res.data.data.token);
						console.log("返回数据",)
						uni.setStorageSync("userinfo",res.data.data.userinfo);
						uni.switchTab({
							url: "../index/index"
						})
					}
				});
			},
		}
	}
</script>

<style lang="less" scoped>
	.top_content{
		text-align: center;
		image{
			height: 200rpx;
			width: 200rpx;
			margin: 20rpx 0;
		}
	}
	.main_content{
		.moudle{
			padding: 20rpx;
			margin: 2rpx 0;
			background-color: #FFFFFF;
			display: flex;
			justify-content: space-between;
			.right_content{
				display: flex;
				.label_text{
					color: #303133;
				}
				.text{
					margin-left: 50rpx;
					color: #909399;
				}
			}
		}
		.btn{
			margin: 20rpx 0;
			text-align: center;
			button{
				background-color: #409EFF;
				color: #FFFFFF;
				width: 40%;
			}
		}
	}
	.foot_content{
		margin-left: 30%;
		position: fixed;
		bottom: 0;
		display: flex;
		color: #CCCCCC;
		view{
			padding: 20rpx;
		}
	}
</style>
