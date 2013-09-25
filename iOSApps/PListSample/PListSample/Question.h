//
//  Person.h
//  PListSample
//
//  Created by 藤田 泰介 on 11/09/02.
//  Copyright (c) 2012年 Revolution 9. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Answer.h"


@interface Question : NSObject <NSCoding> {
  @private
    NSString *question;
    Answer *answer1;
    Answer *answer2;
    Answer *answer3;
    NSNumber *qID;
    
}

@property (nonatomic, strong) NSString *question;
@property (nonatomic, strong) Answer *answer1;
@property (nonatomic, strong) Answer *answer2;
@property (nonatomic, strong) Answer *answer3;
@property (nonatomic, strong) NSNumber *qID;

@end
