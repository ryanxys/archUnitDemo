package com.example.archUnit;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchIgnore;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.GeneralCodingRules;

import static com.tngtech.archunit.library.GeneralCodingRules.*;

@AnalyzeClasses(packages = "com.example.archUnit",
								importOptions = {CustomImportOption.class,
												         ImportOption.DoNotIncludeJars.class,
												         ImportOption.DoNotIncludeTests.class})
public class CodingRulesTest {


	/**
	 * 禁止使用字段注入 (Autowired; Resource; Inject)
	 */
	@ArchTest
	private final ArchRule no_field_injection = NO_CLASSES_SHOULD_USE_FIELD_INJECTION;

	/**
	 * 禁止使用系统标准流   System.out   System.err.    e.printStackTrace()
	 * ArchIgnore 以这种方式标记的规则将在评估期间跳过
	 */
	@ArchIgnore
	@ArchTest
	private final ArchRule NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS = GeneralCodingRules.NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;

	/**
	 * 禁止抛出通用异常 Throwable, Exception, RuntimeException
	 */
	@ArchTest
	private final ArchRule no_generic_exceptions = NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;

	/**
	 * 禁止使用java.util.logging 下的日志组件
	 */
	@ArchTest
	private final ArchRule no_java_util_logging = NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING;

	@ArchTest
	private final ArchRule no_class_use_jodaTime = NO_CLASSES_SHOULD_USE_JODATIME;
}
