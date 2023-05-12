<template>	
	<view class="tabs" >
		<!--标题-->
		<!-- 备用tabs-->
		<!-- <scroll-view class="tabs_title" scroll-x="true" @scroll scroll-left="120" show-scrollbar>
			<view v-for="item in tabs" :key="item.id"
				@click="handleItemTap(item.id)"
				class="title_item" :class="item.isActive ? 'active' : '' ">
				{{item.value}}
			</view>
		</scroll-view> -->
		<!-- 不能滚动的tabs-->
		<view class="tabs_title">
			<view v-for="item in tabs" :key="item.id"
				@click="handleItemTap(item.id)"
				class="title_item" :class="item.isActive ? 'active' : '' ">
				{{item.value}}
			</view>
		</view>
	
		
		<view class="tabs_content">
			<slot></slot>
		</view>
	</view>	
</template>

<script>
	export default {
		name:"Tabs",
		props:{
			tabs:Array
		},
		data() {
			return {
				
			};
		},
		
		methods:{
			//子组件给父组件传值
			handleItemTap(index){
			  this.$emit("tabsItemChange",index);
			}
		}
	}
</script>
	
<style lang="scss">
	.tabs{
		width: 100%;
	}
	// 备用tabs
	// .tabs_title{
	// 	background-color: #FFFFFF;
	// 	white-space: nowrap;	//必须加上
	// 	//隐藏滚动条
	// 	::-webkit-scrollbar {
	// 			width: 0;
	// 			height: 0;
	// 			background-color: transparent;
	// 		} 
	// }
	.tabs_title{
		background-color: #FFFFFF;
		display: flex;
		justify-content: space-around;
	}
	.title_item{
		display: inline-block;
	    padding: 15rpx 15rpx;
	}
	.active{
	    color:red;
	    border-bottom: 5rpx solid currentColor;
	}
	.tabs_content{}
</style>
