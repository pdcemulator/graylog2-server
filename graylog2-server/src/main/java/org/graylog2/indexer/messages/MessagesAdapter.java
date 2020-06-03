/**
 * This file is part of Graylog.
 *
 * Graylog is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Graylog is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Graylog.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.graylog2.indexer.messages;

import org.graylog2.indexer.IndexFailure;
import org.graylog2.indexer.results.ResultMessage;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

public interface MessagesAdapter {
    ResultMessage get(String messageId, String index) throws IOException, DocumentNotFoundException;

    List<String> analyze(String toAnalyze, String index, String analyzer) throws IOException;

    List<IndexFailure> bulkIndex(List<IndexingRequest> messageList, Consumer<Long> successCallback);
}
