//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: joda-time/src/main/java/org/joda/time/tz/ZoneInfoLogger.java
//

#include "J2ObjC_header.h"

#pragma push_macro("OrgJodaTimeTzZoneInfoLogger_INCLUDE_ALL")
#ifdef OrgJodaTimeTzZoneInfoLogger_RESTRICT
#define OrgJodaTimeTzZoneInfoLogger_INCLUDE_ALL 0
#else
#define OrgJodaTimeTzZoneInfoLogger_INCLUDE_ALL 1
#endif
#undef OrgJodaTimeTzZoneInfoLogger_RESTRICT

#if !defined (OrgJodaTimeTzZoneInfoLogger_) && (OrgJodaTimeTzZoneInfoLogger_INCLUDE_ALL || defined(OrgJodaTimeTzZoneInfoLogger_INCLUDE))
#define OrgJodaTimeTzZoneInfoLogger_

@class JavaLangThreadLocal;

@interface OrgJodaTimeTzZoneInfoLogger : NSObject

#pragma mark Public

- (instancetype)init;

+ (void)setWithBoolean:(jboolean)verbose;

+ (jboolean)verbose;

@end

J2OBJC_STATIC_INIT(OrgJodaTimeTzZoneInfoLogger)

inline JavaLangThreadLocal *OrgJodaTimeTzZoneInfoLogger_get_cVerbose();
inline JavaLangThreadLocal *OrgJodaTimeTzZoneInfoLogger_set_cVerbose(JavaLangThreadLocal *value);
/*! INTERNAL ONLY - Use accessor function from above. */
FOUNDATION_EXPORT JavaLangThreadLocal *OrgJodaTimeTzZoneInfoLogger_cVerbose;
J2OBJC_STATIC_FIELD_OBJ(OrgJodaTimeTzZoneInfoLogger, cVerbose, JavaLangThreadLocal *)

FOUNDATION_EXPORT jboolean OrgJodaTimeTzZoneInfoLogger_verbose();

FOUNDATION_EXPORT void OrgJodaTimeTzZoneInfoLogger_setWithBoolean_(jboolean verbose);

FOUNDATION_EXPORT void OrgJodaTimeTzZoneInfoLogger_init(OrgJodaTimeTzZoneInfoLogger *self);

FOUNDATION_EXPORT OrgJodaTimeTzZoneInfoLogger *new_OrgJodaTimeTzZoneInfoLogger_init() NS_RETURNS_RETAINED;

FOUNDATION_EXPORT OrgJodaTimeTzZoneInfoLogger *create_OrgJodaTimeTzZoneInfoLogger_init();

J2OBJC_TYPE_LITERAL_HEADER(OrgJodaTimeTzZoneInfoLogger)

#endif

#pragma pop_macro("OrgJodaTimeTzZoneInfoLogger_INCLUDE_ALL")