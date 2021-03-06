/*
 * The Alluxio Open Foundation licenses this work under the Apache License, version 2.0
 * (the "License"). You may not use this work except in compliance with the License, which is
 * available at www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied, as more fully set forth in the License.
 *
 * See the NOTICE file distributed with this work for information regarding copyright ownership.
 */

package alluxio.cli.fs.command;

import alluxio.client.block.AlluxioBlockStore;
import alluxio.client.file.FileSystem;

import org.apache.commons.cli.CommandLine;

import java.io.IOException;

import javax.annotation.concurrent.ThreadSafe;

/**
 * Gets number of bytes used in the {@link FileSystem}.
 */
@ThreadSafe
public final class GetUsedBytesCommand extends AbstractFileSystemCommand {
  /**
   * Constructs a new instance to get the number of bytes used in the {@link FileSystem}.
   *
   * @param fs the filesystem of Alluxio
   */
  public GetUsedBytesCommand(FileSystem fs) {
    super(fs);
  }

  @Override
  public String getCommandName() {
    return "getUsedBytes";
  }

  @Override
  protected int getNumOfArgs() {
    return 0;
  }

  @Override
  public int run(CommandLine cl) throws IOException {
    AlluxioBlockStore blockStore = AlluxioBlockStore.create();
    long usedBytes = blockStore.getUsedBytes();
    System.out.println("Used Bytes: " + usedBytes);
    return 0;
  }

  @Override
  public String getUsage() {
    return "getUsedBytes";
  }

  @Override
  public String getDescription() {
    return "Gets number of bytes used in the Alluxio file system.";
  }
}
