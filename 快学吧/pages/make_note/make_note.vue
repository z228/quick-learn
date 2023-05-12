<template>
	<view>
		<view>
			<form class="main_content" @submit="formSubmit">
				<view class="titleStyle">
					<input name="title" type="text" placeholder="标题" />
				</view>
				
				<textarea placeholder="请在这里输入您想输入的内容" name="content" auto-height></textarea>
				<view class="uni-btn">
					<button form-type="submit">Submit</button>
				</view>
			</form>
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
				this.$request.get("/note/addnote",{
					"note":JSON.stringify(e.detail.value),
				}).then(res=>{
					if(res.data=="ok"){
						uni.showModal({
							content: '添加成功',
							showCancel: false
						});
						uni.navigateTo({
							url:"../note/note"
						})
					}
				});
			},

		}
	}
</script>

<style lang="less" scoped>
	.main_content{
		.titleStyle{
			padding: 10rpx;
			margin: 15rpx;
			background-color: #FFFFFF;
		}
		textarea{
			margin: 20rpx;
			// background-color: #FFFFFF;
			height: 70%;
		}
		.uni-btn{
			width: 100%;
			position: absolute;
			bottom: 0;
			button{
				margin-left:30%;
				background-color: #409EFF;
				color: #FFFFFF;
				width: 40%;
			}
		}
	}
	
</style>