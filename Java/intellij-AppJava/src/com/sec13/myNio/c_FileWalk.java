package com.sec13.myNio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class c_FileWalk {

	public static void main(String[] args) {
		Path startPath = Paths.get("."); // 현재 디렉토리부터 순회

		System.out.println("--- 모든 파일 및 디렉토리 출력 ---");
		try (Stream<Path> stream = Files.walk(startPath)) {
			stream.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("\n--- 특정 깊이까지만 순회 (최대 깊이 2) ---");
		try (Stream<Path> stream = Files.walk(startPath, 2)) {
			stream.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("\n--- 특정 확장자를 가진 파일만 찾기 ---");
		String fileExtension = ".java";
		try (Stream<Path> stream = Files.walk(startPath)) {
			stream.filter(Files::isRegularFile) // 파일만 필터링
					.filter(path -> path.toString().endsWith(fileExtension)) // 특정 확장자 필터링
					.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("\n--- a로 시작하는 파일만 찾기 ---");

		try (Stream<Path> stream = Files.walk(startPath)) {
			stream.filter(Files::isRegularFile) // 일반 파일만 필터링
					.filter(path -> path.getFileName().toString().startsWith("a_")) // 파일명 기준 필터링
					.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("\n--- a_로 시작하고 .java로 끝나는 파일만 찾기 ---");

		try (Stream<Path> stream = Files.walk(startPath)) {
			stream.filter(Files::isRegularFile) // 일반 파일만 필터링
					.filter(path -> path.getFileName().toString().startsWith("a_"))
					.filter(path -> path.getFileName().toString().endsWith(".java")) // 파일명 기준 필터링
					.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Files.walkFileTree(startPath, new SimpleFileVisitor<Path>(){
				@Override
				public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
					return super.preVisitDirectory(dir, attrs);
				}

				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					return super.visitFile(file, attrs);
				}

				@Override
				public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
					return super.visitFileFailed(file, exc);
				}

				@Override
				public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
					return super.postVisitDirectory(dir, exc);
				}
			});
		} catch (IOException e) {
			throw new RuntimeException(e);
		}


    }
}