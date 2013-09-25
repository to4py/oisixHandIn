//
//  Address.h
//  PListSample
//
//  Created by 藤田 泰介 on 11/09/02.
//  Copyright (c) 2012年 Revolution 9. All rights reserved.
//

#import <Foundation/Foundation.h>


@interface Answer : NSObject <NSCoding> {
    NSString *answer;
    NSNumber *point;

    
}

@property (nonatomic, retain) NSString *answer;
@property (nonatomic) NSNumber *point;


@end
