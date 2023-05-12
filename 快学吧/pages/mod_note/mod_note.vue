<template>
	<view>
		<form class="main_content" @submit="formSubmit">
			<view class="titleStyle">
				<input class="isHidden" name="nid" type="text" disabled="true" :value="note.nid"/>
				<input name="title" type="text" :value="note.title" />
			</view>
			
			<textarea :value="note.content" name="content" auto-height></textarea>
			<view class="uni-btn">
				<button form-type="submit">Submit</button>
			</view>
		</form>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				note:{}
			}
		},
		methods: {
			formSubmit: function(e) {
				this.$request.get("/note/modnote",{
					"note":JSON.stringify(e.detail.value),
				}).then(res=>{
					if(res.data=="ok"){
						uni.navigateTo({
							url:"../note/note"
						})
						
					}
					
				});
			},
		},
		onLoad() {
			//接收上一个页面传来的参数
			var nid=this.$route.query.nid;
			this.$request.get("/note/getNoteById",{
				"nid":nid
			}).then(res=>{
				this.note=res.data
			})
		}
	}
</script>

<style lang="less" scoped>
	.main_content{
		.titleStyle{
			padding: 10rpx;
			margin: 15rpx;
			background-color: #FFFFFF;
			.isHidden{
				display: none;
			}
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