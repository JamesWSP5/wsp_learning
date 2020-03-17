# -*- coding:utf-8 -*-
# @Time : 2020/3/12 10:04
# @Author: wsp

WECHAT_SHARE_POINTS = '''
SELECT source,
       topic,
       log_type,
       sub_log_type
FROM dw.log_table
LEFT JOIN dw.log_table__job_keys ON log_table.`_id`=log_table__job_keys.upper_id
WHERE log_table__job_keys.job_keys_item IS NOT NULL
  AND log_table__job_keys.job_keys_item='{item}'
'''
items = ['UNIT_MLS_SHARE_COUNT',
         'HOUSE_BILL_SHARE_COUNT',
         'SMARTPROGRAM_BILL_SHARE_COUNT',
         'UNIT_MULTIPLE_CHOICE_SHARE_COUNT',
         'UNIT_COLLECTION_SHARE_COUNT',
         'MY_HOME_PAGE_SHARE_COUNT',
         'SMARTPROGRAM_CARD_SHARE_COUNT',
         'NET_SHOP_SHARE_COUNT',
         'TEMP_COLLECTION_SHARE_COUNT',
         'SHOP_COLLECTION_SHARE_COUNT',
         'NEW_HOUSE_SHARE_COUNT',
         'UNIT_MLS_SHARE_FRIEND_COUNT',
         'HOUSE_BILL_WECHATHELPER_SHARE_FRIEND_COUNT',
         'SMARTPROGRAM_BILL_SHARE_FRIEND_COUNT',
         'UNIT_MULTIPLE_CHOICE_SHARE_FRIEND_COUNT',
         'UNIT_COLLECTION_SHARE_FRIEND_COUNT',
         'MY_HOME_PAGE_SHARE_FRIEND_COUNT',
         'SMARTPROGRAM_CARD_SHARE_FRIEND_COUNT',
         'NET_SHOP_SHARE_FRIEND_COUNT',
         'TEMP_COLLECTION_SHARE_FRIEND_COUNT',
         'SHOP_COLLECTION_SHARE_FRIEND_COUNT',
         'NEW_HOUSE_SHARE_FRIEND_COUNT'
         ]

items_df = ['unit_mls_share_count_df',
            'house_bill_share_count_df',
            'smartprogram_bill_share_count_df',
            'unit_multiple_choice_share_count_df',
            'unit_collection_share_count_df',
            'my_home_page_share_count_df',
            'smartprogram_card_share_count_df',
            'net_shop_share_count_df',
            'temp_collection_share_count_df',
            'shop_collection_share_count_df',
            'new_house_share_count_df',
            'unit_mls_share_friend_count_df',
            'house_bill_wechathelper_share_friend_count_df',
            'smartprogram_bill_share_friend_count_df',
            'unit_multiple_choice_share_friend_count_df',
            'unit_collection_share_friend_count_df',
            'my_home_page_share_friend_count_df',
            'smartprogram_card_share_friend_count_df',
            'net_shop_share_friend_count_df',
            'temp_collection_share_friend_count_df',
            'shop_collection_share_friend_count_df',
            'new_house_share_friend_count_df']

keys = ['unit_mls_share_count',
        'house_bill_share_count',
        'smartprogram_bill_share_count',
        'unit_multiple_choice_share_count',
        'unit_collection_share_count',
        'my_home_page_share_count',
        'smartprogram_card_share_count',
        'net_shop_share_count',
        'wechathelper_share_count',
        'temp_collection_share_count',
        'shop_collection_share_count',
        'new_house_share_count',
        'unit_mls_share_friend_count',
        'house_bill_wechathelper_share_friend_count',
        'smartprogram_bill_share_friend_count',
        'unit_multiple_choice_share_friend_count',
        'unit_collection_share_friend_count',
        'my_home_page_share_friend_count',
        'smartprogram_card_share_friend_count',
        'net_shop_share_friend_count',
        'temp_collection_share_friend_count',
        'shop_collection_share_friend_count',
        'new_house_share_friend_count'
        ]

points_df = '''
    select * 
    from   
    {table_name}
'''

result = '''
 select id,
        count (1) as value_count,
        '{start_date}' as calculate_date
 FROM   dw.user_ab_log_simple 
 WHERE dates='{start_date}' and {sql_str}
 GROUP  BY id
'''
